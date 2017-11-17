package com.gibsoncool.a05_mvp;

/**
 * Created by GibsonCool on 2017/11/15
 */

public interface MvpView
{
	void showLoading();

	void hideLoading();

	void showSuccess(String data);

	void showFailure(String msg);

	void showError();

}
