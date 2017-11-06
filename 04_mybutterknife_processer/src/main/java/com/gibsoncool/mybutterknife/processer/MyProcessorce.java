package com.gibsoncool.mybutterknife.processer;

import com.gibsoncool.mybutterknife.annotation.BindView;
import com.gibsoncool.mybutterknife.annotation.OnClick;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

/**
 * Created by GibsonCool on 2017/11/1
 */

@AutoService(Processor.class)
public class MyProcessorce extends AbstractProcessor
{
	private Filer    mFileUtils;    //跟文件相关的辅助类，生成JavaSourceCode.
	private Elements mElementUtils;    //跟元素相关的辅助类，帮助我们去获取一些元素相关的信息。
	private Messager mMessager;    //跟日志相关的辅助类。

	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment)
	{
		super.init(processingEnvironment);
		mFileUtils = processingEnvironment.getFiler();
		mElementUtils = processingEnvironment.getElementUtils();
		mMessager = processingEnvironment.getMessager();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes()
	{
		Set<String> annotataions = new LinkedHashSet<String>();
		annotataions.add(BindView.class.getCanonicalName());
		annotataions.add(OnClick.class.getCanonicalName());
		return annotataions;
	}

	@Override
	public SourceVersion getSupportedSourceVersion()
	{
		return SourceVersion.latestSupported();
	}


	@Override
	public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment)
	{

//		// 调试打印
//		System.out.println("------------------------------------>");
//		System.out.println("------------------------------------>");
		// 解析 Element
		Map<Element, List<Element>> analysisElementMap = new LinkedHashMap<>();

		Set<? extends Element> bindViewElements = roundEnvironment.getElementsAnnotatedWith(BindView.class);
		Set<? extends Element> onClickElements = roundEnvironment.getElementsAnnotatedWith(OnClick.class);
		for (Element el : bindViewElements)
		{
			Element enclosingElement = el.getEnclosingElement();

			List<Element> elements = analysisElementMap.get(enclosingElement);
			if (elements == null)
			{
				elements = new ArrayList<>();
				analysisElementMap.put(enclosingElement, elements);
			}

			elements.add(el);
		}

//		for (Element el : onClickElements)
//		{
//
//			Element enclosingElement = el.getEnclosingElement();
//
//			List<Element> elements = analysisElementMap.get(enclosingElement);
//			if (elements == null)
//			{
//				elements = new ArrayList<>();
//				analysisElementMap.put(enclosingElement, elements);
//			}
//
//			elements.add(el);
//		}

		for (Map.Entry<Element, List<Element>> entry : analysisElementMap.entrySet())
		{
			Element enclosingElement = entry.getKey();
			List<Element> elements = entry.getValue();

			String classNameStr = enclosingElement.getSimpleName().toString();
			// 组装类:  xxx_ViewBinding implements Unbinder
			TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(classNameStr + "_$$ViewBinding")
					.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
//						.addSuperinterface(unbinderClassName);

			// 组装构造函数: public xxx_ViewBinding(xxx target)
			ClassName parameterClassName = ClassName.bestGuess(classNameStr);
			MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
					.addModifiers(Modifier.PUBLIC)
					.addParameter(parameterClassName, "target");
			for (Element el : elements)
			{
//				System.out.print(enclosingElement.getSimpleName() + "----" + enclosingElement.asType().toString() + "----" + enclosingElement.getEnclosingElement() + "\n");
				System.out.print(el.getSimpleName() + "----" + el.asType().toString() + "----" + el.getEnclosingElement() + "\n");


				String filedName = el.getSimpleName().toString();
				int resId = el.getAnnotation(BindView.class).value();
				TypeMirror string = el.asType();

				System.out.print(filedName + "----" + resId + "----" + "\n");
				System.out.print("*******************************\n");
				/**
				 * $L 代表的是字面量
				 * $S for Strings
				 * $N for Names(我们自己生成的方法名或者变量名等等)
				 * $T for Types 这里的$T，在生成的源代码里面，也会自动导入你的类。
				 */
				constructorBuilder.addStatement("target.$N = ($T)target.findViewById($L)",
						filedName, string, resId);


			}

			String logPgname = "android.util.Log";
			constructorBuilder.addStatement("$L.e(\"cxxinfo\",\"apt has been do it\")", logPgname);

			typeSpecBuilder.addMethod(constructorBuilder.build());
//			typeSpecBuilder.addMethod(unbindMethodBuilder.build());

			try
			{
				// 写入生成 java 类
				String packageName = mElementUtils.getPackageOf(enclosingElement).getQualifiedName().toString();
				JavaFile.builder(packageName, typeSpecBuilder.build())
						.addFileComment("ButterKnife自动生成")
						.build().writeTo(mFileUtils);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.out.println("翻车了");
			}
		}

		return false;
	}

}
