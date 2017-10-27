package com.gibsoncool.dynamicproxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by GibsonCool on 2017/10/26
 */

public class DynamicSecretary implements InvocationHandler
{
	private Object sub;

	public DynamicSecretary(Object object)
	{
		this.sub = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{


		String strBefor = "调用前的文字信息\n";
		String strObject = (String) method.invoke(sub, args);
		String strAfter = "\n方法调用后加上的文字!!!";

		return strBefor + strObject + " method name :" + method.getName()
				+ "\n"+ proxy.getClass().getName()
				+ "\n"+ proxy.getClass().getSuperclass().getName()
				+ "\n"+ proxy.getClass().getInterfaces().getClass().getName()
				+ strAfter;
	}
}
