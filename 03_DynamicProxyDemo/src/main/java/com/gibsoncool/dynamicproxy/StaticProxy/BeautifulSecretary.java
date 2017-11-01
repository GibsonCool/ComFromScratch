package com.gibsoncool.dynamicproxy.StaticProxy;

/**
 * Created by GibsonCool on 2017/10/26
 */

public class BeautifulSecretary implements Workers
{
	String girlName = "小甜甜";
	Boss sbBoss;

	public BeautifulSecretary(Boss boss)
	{
		sbBoss = boss;
	}

	@Override
	public String signFile(String fileName)
	{
		String fileStr = sbBoss.signFile(girlName + "整理归类好的" + fileName);
		return fileStr + "\n下班回家洗澡澡";
	}

	@Override
	public String singSong(String songName)
	{
		return "美女秘书唱了一首" + songName;
	}
}
