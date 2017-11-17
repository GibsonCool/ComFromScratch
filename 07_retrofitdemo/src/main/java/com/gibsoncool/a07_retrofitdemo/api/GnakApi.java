package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.GnakBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GibsonCool on 2017/11/17
 */

public interface GnakApi
{
	@GET("api/data/Android/10/1")
	Call<GnakBean> getAndroidInfo();
}
