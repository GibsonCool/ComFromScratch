package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GibsonCool on 2017/11/17
 */

public interface WeatherApi
{
	@GET("weather/index?cityname=深圳")
	Call<WeatherGsonBean> getWeather(@Query("key") String key);
}
