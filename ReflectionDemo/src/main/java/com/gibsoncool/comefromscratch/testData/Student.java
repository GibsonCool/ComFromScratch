package com.gibsoncool.comefromscratch.testData;

import com.gibsoncool.comefromscratch.utils.Controls;
import com.gibsoncool.comefromscratch.utils.LogUtils;

/**
 * Created by GibsonCool on 2017/10/21 0021.
 */

public class Student extends Person implements Controls.Examination {
    int age=100;    // 年龄

    public Student(String mName) {
        super(mName);
    }

    public Student(String mName, int age) {
        super(mName);
        this.age = age;
    }

    private void learn(String course) {
        LogUtils.e(mName + " learn " + course);

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

}
