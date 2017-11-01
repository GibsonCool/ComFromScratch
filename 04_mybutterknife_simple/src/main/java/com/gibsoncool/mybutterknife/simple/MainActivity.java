package com.gibsoncool.mybutterknife.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.mybutterknife.annotation.BindView;
import com.gibsoncool.mybutterknife.annotation.MyAnnotation;
import com.gibsoncool.mybutterknife.annotation.OnClick;

@MyAnnotation("GibsonCool mainActivity")
public class MainActivity extends AppCompatActivity
{

	@BindView(R.id.hello)
	TextView     hello;
	@BindView(R.id.button)
	Button       button;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	@OnClick(R.id.button)
	public void onclick(View view)
	{

	}
}
