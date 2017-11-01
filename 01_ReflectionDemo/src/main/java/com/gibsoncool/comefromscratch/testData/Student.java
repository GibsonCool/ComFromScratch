package com.gibsoncool.comefromscratch.testData;

import com.gibsoncool.comefromscratch.MyselfApplication;
import com.gibsoncool.comefromscratch.utils.Controls;
import com.gibsoncool.comefromscratch.utils.LogUtils;
import com.gibsoncool.comefromscratch.utils.ToastUtils;

/**
 * Created by GibsonCool on 2017/10/21 0021.
 */

public class Student extends Person implements Controls.Examination,Controls.Sports
{
    int age=100;    // 年龄
    public int height = 89;

    public Student(String mName) {
        super(mName);
    }

    public Student(String mName, int age) {
        super(mName);
        this.age = age;
    }

    private void learn(String course) {
        LogUtils.e(mName + " learn " + course);
        ToastUtils.showShortToast(MyselfApplication.getMyApplication(),mName + " learn " + course);
    }

    public void sing(String singName){
        LogUtils.e(mName + " sing a song: " + singName);
        ToastUtils.showShortToast(MyselfApplication.getMyApplication(),mName + " sing a song: " + singName);
    }

    @Override
    public void takeAnExamination() {
        LogUtils.e(" 考试 ");
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                "  ,mName="+mName+
                '}';
    }

    @Override
    public void playBasketBall()
    {
        LogUtils.e(mName + " play basketball  " );
        ToastUtils.showShortToast(MyselfApplication.getMyApplication(),mName + " play basketball  ");
    }
}
