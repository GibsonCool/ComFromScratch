package com.gibsoncool.annotationdemo.customeAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by GibsonCool on 2017/10/25
 * <p>
 * 自定义运行时注解，此类型注解可以通过反射调用获取相关信息
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MethodInfo
{
	public enum MethodVersion
	{
		First, Two, Three
	}

	String author() default "GibsonCool";

	String methodName();

	MethodVersion version() default MethodVersion.First;

}
