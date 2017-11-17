package com.gibsoncool.a05_mvp;

/**
 * Created by GibsonCool on 2017/11/15
 */

public interface MvpCallback
{
	void onSuccess(String data);

	void onFailure(String msg);

	void onError();

	void onCompleted();
}
