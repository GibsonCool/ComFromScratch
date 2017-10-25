package com.gibsoncool.comefromscratch.testData;

import com.gibsoncool.comefromscratch.MyselfApplication;
import com.gibsoncool.comefromscratch.utils.LogUtils;
import com.gibsoncool.comefromscratch.utils.ToastUtils;

/**
 * Created by GibsonCool
 * on 2017/10/24.
 * Describe:
 */

public class SmallStudent extends Student
{
	String grade = "五年级";

	public SmallStudent(String mName)
	{
		super(mName);
	}

	public SmallStudent(String mName, int age)
	{
		super(mName, age);
	}

	public void WriteHomeWork()
	{
		LogUtils.e(mName + grade + "天天写作业");
		ToastUtils.showShortToast(MyselfApplication.getMyApplication(), mName + grade + "天天写作业");
	}

}
