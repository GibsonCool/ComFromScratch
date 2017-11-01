package com.gibsoncool.mybutterknife.processer;

import com.gibsoncool.mybutterknife.annotation.BindView;
import com.gibsoncool.mybutterknife.annotation.MyAnnotation;
import com.gibsoncool.mybutterknife.annotation.OnClick;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

/**
 * Created by GibsonCool on 2017/11/1
 */

@AutoService(Processor.class)
public class MyProcessorce extends AbstractProcessor
{
	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment)
	{
		super.init(processingEnvironment);
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
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}


	@Override
	public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment)
	{
		// roundEnv.getElementsAnnotatedWith()返回使用给定注解类型的元素
		for (Element element : roundEnvironment.getElementsAnnotatedWith(MyAnnotation.class)) {
			System.out.println("------------------------------");
			// 判断元素的类型为Class
			if (element.getKind() == ElementKind.CLASS) {
				// 显示转换元素类型
				TypeElement typeElement = (TypeElement) element;
				// 输出元素名称
				System.out.println(typeElement.getSimpleName());
				// 输出注解属性值
				System.out.println(typeElement.getAnnotation(MyAnnotation.class).value());
			}
			System.out.println("------------------------------");
		}
		return false;
	}

}
