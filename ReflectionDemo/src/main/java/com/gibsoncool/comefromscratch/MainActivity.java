package com.gibsoncool.comefromscratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.comefromscratch.testData.Student;
import com.gibsoncool.comefromscratch.utils.LogUtils;
import com.gibsoncool.comefromscratch.utils.ToastUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

	Class<?> studentClass = null;
	Object   instance     = null;


	@BindView(R.id.Class)
	Button       btClass;
	@BindView(R.id.getClass)
	Button       btGetClass;
	@BindView(R.id.forName)
	Button       btClassForName;
	@BindView(R.id.show_detail)
	TextView     tvDetail;
	@BindView(R.id.show_method_detail)
	TextView     tvMethodDetail;
	@BindView(R.id.getDeclaredMethods)
	Button       getDeclaredMethods;
	@BindView(R.id.getMethods)
	Button       getMethods;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;
	@BindView(R.id.getDeclaredFields)
	Button       getDeclaredFields;
	@BindView(R.id.getFields)
	Button       getFields;
	@BindView(R.id.show_fields_detail)
	TextView     showFieldsDetail;
	@BindView(R.id.tv_age)
	TextView     tvAge;
	@BindView(R.id.getSuperClass)
	Button       getSuperClass;
	@BindView(R.id.getInterfaces)
	Button       getInterfaces;
	@BindView(R.id.tv_super_interface)
	TextView     tvSuperInterface;
	@BindView(R.id.show_super_interface_detail)
	TextView     showSuperInterfaceDetail;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	@OnClick({R.id.Class, R.id.getClass, R.id.forName, R.id.getDeclaredMethods, R.id.getMethods, R.id.getDeclaredFields, R.id.getFields, R.id.getSuperClass, R.id.getInterfaces})
	public void btnClick(Button btn)
	{

		try
		{
			switch (btn.getId())
			{
				//class相关
				case R.id.Class:
					studentClass = Student.class;
					Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
					constructor.setAccessible(true);
					instance = constructor.newInstance("from Class", 21);
					tvDetail.setText(instance.toString());
					break;
				case R.id.getClass:
					studentClass = new Student("cxx", 23).getClass();
					Constructor<?> constructor2 = studentClass.getConstructor(String.class, int.class);
					instance = constructor2.newInstance("from getClass", 22);
					tvDetail.setText(instance.toString());
					break;
				case R.id.forName:
					studentClass = Class.forName("com.gibsoncool.comefromscratch.testData.Student");
					Constructor<?> constructor3 = studentClass.getConstructor(String.class, int.class);
					instance = constructor3.newInstance("from Class.forName", 23);
					tvDetail.setText(instance.toString());
					break;

				//metho相关
				case R.id.getDeclaredMethods:
					showDeclaredMethods();
					break;
				case R.id.getMethods:
					showMethods();
					break;

				//field相关
				case R.id.getDeclaredFields:
					getDeclaredFields();
					break;
				case R.id.getFields:
					getFields();
					break;

				//superclass  interface相关
				case R.id.getSuperClass:
					getSuperClass();
					break;
				case R.id.getInterfaces:
					getInterfaces();
					break;

			}
		}
		catch (Exception e)
		{
			tvDetail.setText(e.toString());
		}

	}

	/**
	 * @deprecated hhahaah
	 * 获取该 Class 对象中的所有函数(只是当前类定义的函数， 不包含从父类继承的函数 )
	 */
	private void showDeclaredMethods()
	{
		if (studentClass == null)
		{
			ToastUtils.showLongToast(this, "请先选择一种方式生成Class对象");
			return;
		}

		String strMethod = "";
		Method[] methods = studentClass.getDeclaredMethods();
		for (Method method : methods)
		{
			strMethod += "\ndeclared method name : " + method.getName();
		}
		tvMethodDetail.setText(strMethod);
		try
		{
			Method learnMethod = studentClass.getDeclaredMethod("learn", String.class);

			LogUtils.e(learnMethod.getName() + " is private "
					+ Modifier.isPrivate(learnMethod.getModifiers()));
			learnMethod.setAccessible(true);
			learnMethod.invoke(instance, "java ---> ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			tvMethodDetail.setText(tvMethodDetail.getText().toString() + "\n" + e.getMessage());
		}
	}

	/**
	 * 获取该 Class 对象中的所有**公有(即public修饰的)**函数 ( 包含从父类和接口类集成下来的函数 )
	 */
	private void showMethods()
	{

		if (studentClass == null)
		{
			ToastUtils.showShortToast(this, "请先选择一种方式生成Class对象");
			return;
		}

		String strMethod = "";
		// 获取所有方法
		Method[] methods = studentClass.getMethods();
		for (Method method : methods)
		{
			strMethod += "\nmethod name : " + method.getName();
		}
		tvMethodDetail.setText(strMethod);
		try
		{
//			// 通过 getMethod 只能获取公有方法，如果获取私有方法则会抛出异常，比如这里就会抛异常
//			Method learnMethod = studentClass.getMethod("learn", String.class);
//			// 是否是 private 函数，属性是否是 private 也可以使用这种方式判断
//			LogUtils.e(learnMethod.getName() + " is private " + Modifier.isPrivate(learnMethod.getModifiers()));
//			// 调用 learn 函数
//			learnMethod.invoke(instance, "java");

			Method singMethod = studentClass.getMethod("sing", String.class);
			LogUtils.e(singMethod.getName() + " is private " + Modifier.isPrivate(singMethod.getModifiers()));
			singMethod.invoke(instance, "你问我爱你有多深");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			tvMethodDetail.setText(tvMethodDetail.getText().toString() + "\n" + e.getMessage());
		}
	}

	/**
	 * 获取该 class 对象中的所有属性（只是当前类定义的属性， 不包含从父类继承的属性）
	 */
	private void getDeclaredFields()
	{
		if (studentClass == null)
		{
			ToastUtils.showLongToast(this, "请先选择一种方式生成Class对象");
			return;
		}
		String strFields = "";
		Field[] declaredFields = studentClass.getDeclaredFields();
		for (Field field : declaredFields)
		{
			field.setAccessible(true);
			strFields += "\ndeclared field name : " + field.getName();
		}
		showFieldsDetail.setText(strFields);

		try
		{
			Field age = studentClass.getDeclaredField("age");
			age.setAccessible(true);
			int anInt = age.getInt(instance);
			tvAge.setText("age:" + String.valueOf(anInt));
		}
		catch (Exception e)
		{

		}
	}

	/**
	 * 获取该 Class 对象中的所有**公有(即public修饰的)**属性 ( 包含从父类和接口类集成下来的属性 )
	 */
	private void getFields()
	{
		if (studentClass == null)
		{
			ToastUtils.showLongToast(this, "请先选择一种方式生成Class对象");
			return;
		}
		String strFields = "";
		Field[] fields = studentClass.getFields();
		for (Field field : fields)
		{
			strFields += "\nfield name : " + field.getName();
		}
		showFieldsDetail.setText(strFields);
	}

	/**
	 * 循环获取该 class 对象的父类信息
	 */
	private void getSuperClass()
	{
		if (studentClass == null)
		{
			ToastUtils.showLongToast(this, "请先选择一种方式生成Class对象");
			return;
		}
		Class<?> superclass = studentClass.getSuperclass();
		String strSuperclass = studentClass.getName();
		while (superclass != null)
		{
			strSuperclass += "super class is :" + superclass.getName() + "\n" + superclass.getName();
			superclass = superclass.getSuperclass();
		}

		showSuperInterfaceDetail.setText(strSuperclass);
	}

	/**
	 * 获取该 class 实现的所有接口类
	 */
	private void getInterfaces()
	{
		if (studentClass == null)
		{
			ToastUtils.showLongToast(this, "请先选择一种方式生成Class对象");
			return;
		}
		Class<?>[] interfaces = studentClass.getInterfaces();
		String strInterface = studentClass.getName() + " interface has :";
		for (Class<?> class1 : interfaces)
		{
			strInterface += class1.getName() + "    \n";
		}
		showSuperInterfaceDetail.setText(strInterface);
	}


}

