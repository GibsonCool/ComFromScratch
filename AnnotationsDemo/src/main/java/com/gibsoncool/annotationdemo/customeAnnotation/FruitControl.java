package com.gibsoncool.annotationdemo.customeAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by GibsonCool on 2017/10/26
 */

public interface FruitControl
{
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FruitName
	{
		String value() default "";
	}

	enum Color
	{
		RED, BULE, GREEN
	}

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface FruitColor
	{
		Color fruitColor() default Color.RED;
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface FruitProvider
	{
		int id() default -1;

		String name() default "";

		String address();
	}


	public class Apple
	{

		@FruitName("MyApple")
		private String appleName;

		@FruitColor(fruitColor = Color.GREEN)
		private String appleColor;

		private String appleProvider;

		@FruitProvider(address = "深圳车公庙", name = "GibsonCool")
		private void setAppleProvider()
		{

		}
	}


}
