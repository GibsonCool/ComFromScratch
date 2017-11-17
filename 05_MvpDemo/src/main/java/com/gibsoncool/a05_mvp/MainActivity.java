package com.gibsoncool.a05_mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MvpView
{

	@BindView(R.id.tv_note)
	TextView       tvNote;
	@BindView(R.id.bt_success)
	Button         btSuccess;
	@BindView(R.id.bt_failure)
	Button         btFailure;
	@BindView(R.id.bt_error)
	Button         btError;
	@BindView(R.id.activity_main)
	RelativeLayout activityMain;

	private MvpPresenter   mvpPresenter;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);
		progressDialog.setMessage("数据加载中");
		mvpPresenter = new MvpPresenter(this);

	}

	@Override
	public void showLoading()
	{
		if (!progressDialog.isShowing())
			progressDialog.show();
	}

	@Override
	public void hideLoading()
	{
		if (progressDialog.isShowing())
			progressDialog.dismiss();
	}

	@Override
	public void showSuccess(String data)
	{
		tvNote.setText(data);
	}

	@Override
	public void showFailure(String msg)
	{
		Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
		tvNote.setText(msg);
	}

	@Override
	public void showError()
	{
		Toast.makeText(this,"请求出现异常",Toast.LENGTH_SHORT).show();
		tvNote.setText("请求出现异常");
	}

	@OnClick({R.id.bt_success, R.id.bt_failure, R.id.bt_error})
	public void onViewClicked(View view)
	{
		switch (view.getId())
		{
			case R.id.bt_success:
				mvpPresenter.getData("success");
				break;
			case R.id.bt_failure:
				mvpPresenter.getData("failure");
				break;
			case R.id.bt_error:
				mvpPresenter.getData("error");
				break;
		}
	}
}
