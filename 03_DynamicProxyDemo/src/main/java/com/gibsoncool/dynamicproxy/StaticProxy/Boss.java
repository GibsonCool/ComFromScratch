package com.gibsoncool.dynamicproxy.StaticProxy;

/**
 * Created by GibsonCool on 2017/10/26
 */

public class Boss implements Workers
{
	String mName = "GibsonCool";

	@Override
	public String signFile(String fileName)
	{
		return mName + "签收了这些文件"+fileName;

	}

	@Override
	public String singSong(String songName)
	{
		return "唱了一首"+songName;
	}
}
