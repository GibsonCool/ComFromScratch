package com.gibsoncool.dynamicproxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.dynamicproxy.DynamicProxy.DynamicSecretary;
import com.gibsoncool.dynamicproxy.StaticProxy.BeautifulSecretary;
import com.gibsoncool.dynamicproxy.StaticProxy.Boss;
import com.gibsoncool.dynamicproxy.StaticProxy.Workers;

import java.lang.reflect.Proxy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

	@BindView(R.id.boss)
	Button       boss;
	@BindView(R.id.boss_secretary)
	Button       bossSecretary;
	@BindView(R.id.show_detail)
	TextView     showDetail;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;

	Boss bigBoss;
	@BindView(R.id.dynamic_secretary)
	Button   dynamicSecretary;
	@BindView(R.id.show_detail_two)
	TextView showDetailTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	@OnClick({R.id.boss, R.id.boss_secretary})
	public void onViewClicked(View view)
	{
		String str = "\"挣它一个亿的文件\"";
		switch (view.getId())
		{
			case R.id.boss:
				bigBoss = new Boss();
				showDetail.setText(bigBoss.signFile(str));
				break;
			case R.id.boss_secretary:
				if (bigBoss == null)
				{
					ToastUtils.showShortToast(this, "老板都没有，你搞个毛！");
					return;
				}
				BeautifulSecretary beautifulSecretary = new BeautifulSecretary(bigBoss);
				showDetail.setText(beautifulSecretary.signFile(str));
				break;
		}
	}

	@OnClick(R.id.dynamic_secretary)
	public void onViewClicked()
	{
		if (bigBoss == null)
		{
			ToastUtils.showShortToast(this, "老板都没有，你搞个毛！");
			return;
		}
		DynamicSecretary dynamicSecretary = new DynamicSecretary(bigBoss);
		Workers object = (Workers) Proxy.newProxyInstance(bigBoss.getClass().getClassLoader(), bigBoss.getClass().getInterfaces(), dynamicSecretary);
		showDetailTwo.setText(object.signFile("《演员的自我修养》")+"\n\n"+object.singSong("《死了都要爱》"));

	}
}
