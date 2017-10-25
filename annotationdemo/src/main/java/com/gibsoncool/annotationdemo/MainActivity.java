package com.gibsoncool.annotationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.annotationdemo.customeAnnotation.MethodInfo;
import com.gibsoncool.annotationdemo.utils.ToastUtils;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

	@BindView(R.id.reflection_runtime)
	Button       reflectionRuntime;
	@BindView(R.id.reflection_runtime_detail)
	TextView     reflectionRuntimeDetail;
	@BindView(R.id.bt2)
	Button       bt2;
	@BindView(R.id.tv2)
	TextView     tv2;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@MethodInfo(author = "from ButterKnife", methodName = "onViewClicked", version = MethodInfo.MethodVersion.Three)
	@OnClick({R.id.reflection_runtime, R.id.bt2})
	public void onViewClicked(View view)
	{
		switch (view.getId())
		{
			case R.id.reflection_runtime:
				testRuntimeAnnotation();
				break;
			case R.id.bt2:
				break;
		}
	}

	@MethodInfo(methodName = "testRuntimeAnnotation", version = MethodInfo.MethodVersion.Two)
	public void testRuntimeAnnotation()
	{
		ToastUtils.showShortToast(this, "testRuntimeAnnotation 被调用了~");
		Class<MainActivity> mainActivityClass = MainActivity.class;
		String str = "";
		for (Method method : mainActivityClass.getMethods())
		{
			MethodInfo annotation = method.getAnnotation(MethodInfo.class);
			if (annotation != null)
				str += annotation.author() + "***" + annotation.methodName() + "***" + annotation.version() + "\n";

			reflectionRuntimeDetail.setText(str);
		}
	}
}
