package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.QueryWeather;
import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by GibsonCool on 2017/11/21
 */

public interface WeatherObjectApi
{
	@POST("weather/index")
	Call<WeatherGsonBean> postObject(@Body QueryWeather body);
}
