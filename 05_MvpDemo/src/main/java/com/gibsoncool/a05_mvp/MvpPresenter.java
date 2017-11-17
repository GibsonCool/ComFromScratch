package com.gibsoncool.a05_mvp;

/**
 * Created by GibsonCool on 2017/11/15
 */

public class MvpPresenter
{
	private MvpView mvpView;

	public MvpPresenter(MvpView view)
	{
		mvpView = view;
	}


	public void getData(String parmas){
		mvpView.showLoading();

		MvpModel.getDataFromNet(parmas, new MvpCallback()
		{
			@Override
			public void onSuccess(String data)
			{
				mvpView.showSuccess(data);
			}

			@Override
			public void onFailure(String msg)
			{
				mvpView.showFailure(msg);
			}

			@Override
			public void onError()
			{
				mvpView.showError();
			}

			@Override
			public void onCompleted()
			{
				mvpView.hideLoading();
			}
		});
	}

}
