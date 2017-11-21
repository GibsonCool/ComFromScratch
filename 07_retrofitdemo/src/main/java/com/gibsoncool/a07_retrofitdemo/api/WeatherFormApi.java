package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by GibsonCool on 2017/11/21
 */

public interface WeatherFormApi
{

	@POST("weather/index")
	Call<WeatherGsonBean> postByForm(@Field("cityname") String name, @Field("key") String key);
}
