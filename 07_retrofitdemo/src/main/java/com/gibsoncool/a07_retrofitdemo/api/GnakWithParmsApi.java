package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.GnakBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GibsonCool on 2017/11/20
 */

public interface GnakWithParmsApi
{
	@GET("api/data/Android/10/{page}")
	Call<GnakBean> getInfo(@Path("page") int page);
}
