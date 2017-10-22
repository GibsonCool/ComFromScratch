package com.gibsoncool.comefromscratch.testData;

import com.gibsoncool.comefromscratch.utils.LogUtils;

/**
 * Created by GibsonCool on 2017/10/21 0021.
 */

public class Person {
    String mName;

    public Person(String mName) {
        this.mName = mName;
    }

    private void sayHello(String friendName) {
        LogUtils.e(friendName);
    }

    protected void showMyName(){
        LogUtils.e(mName);
    }

    public void  doWalk(){
        String str = "行走。。。。";
        LogUtils.e(str);
    }

    @Override
    public String toString() {
        return "Person{" +
                "mName='" + mName + '\'' +
                '}';
    }
}
