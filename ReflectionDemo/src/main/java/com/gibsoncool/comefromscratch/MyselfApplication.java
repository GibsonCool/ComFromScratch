package com.gibsoncool.comefromscratch;

import android.app.Application;

/**
 * Created by Administrator on 2017/10/20.
 */

public class MyselfApplication extends Application
{
	public final static String TAG_ME = "GibsonCool";
	public static MyselfApplication myApplication;

	public static MyselfApplication getMyApplication()
	{
		return myApplication;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		myApplication = this;
	}
}
