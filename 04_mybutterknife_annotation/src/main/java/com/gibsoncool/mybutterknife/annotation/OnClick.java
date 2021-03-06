package com.gibsoncool.mybutterknife.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by GibsonCool on 2017/11/1
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnClick
{
	int[] value();
}
