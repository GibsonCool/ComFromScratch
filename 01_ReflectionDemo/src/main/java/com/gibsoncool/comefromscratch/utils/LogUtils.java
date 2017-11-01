package com.gibsoncool.comefromscratch.utils;

import android.util.Log;

import static com.gibsoncool.comefromscratch.MyselfApplication.TAG_ME;

/**
 * Created by GibsonCool on 2017/10/21 0021.
 */

public class LogUtils {
    public static void v(String message) {
        Log.v(TAG_ME, message);
    }

    public static void d(String message) {
        Log.d(TAG_ME, message);
    }

    public static void i(String message) {
        Log.i(TAG_ME, message);
    }

    public static void w(String message) {
        Log.w(TAG_ME, message);
    }

    public static void e(String message) {
        Log.e(TAG_ME, message);
    }
}
