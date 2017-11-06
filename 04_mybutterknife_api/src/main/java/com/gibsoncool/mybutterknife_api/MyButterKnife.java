package com.gibsoncool.mybutterknife_api;

import java.lang.reflect.Constructor;

/**
 * Created by GibsonCool on 2017/11/6
 */

public class MyButterKnife
{
	public static void inject(Object host)
	{
		Class<?> clazz = host.getClass();
		String proxyClassFullName = clazz.getName() + "_$$ViewBinding";
		//省略try,catch相关代码
		try
		{
			Class<?> proxyClazz = Class.forName(proxyClassFullName);
			Constructor<?> constructor = proxyClazz.getConstructor(host.getClass());
			android.util.Log.e("cxxinfo", "MyButterKnife  " + constructor.getName());
			constructor.setAccessible(true);
			Object o = constructor.newInstance(host);
		}
		catch (Exception e)
		{
			android.util.Log.e("cxxinfo", "艹，挂了" + e.toString());
			e.printStackTrace();
		}

	}
}
