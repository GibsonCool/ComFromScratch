package com.gibsoncool.a05_mvp;

import android.os.Handler;

/**
 * Created by GibsonCool on 2017/11/15
 */

public class MvpModel
{
	public static void getDataFromNet(final String param, final MvpCallback callback)
	{
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				switch (param)
				{
					case "success":
						callback.onSuccess("success");
						break;
					case "failure":
						callback.onFailure("failure");
						break;
					case "error":
						callback.onError();
						break;
				}
				callback.onCompleted();
			}
		}, 2000);
	}
}
