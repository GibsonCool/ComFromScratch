package com.gibsoncool.a07_retrofitdemo.api;

import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by GibsonCool on 2017/11/20
 */

public interface WeatherMapApi
{
	@GET("weather/index?")
	Call<WeatherGsonBean> getWeather(@QueryMap Map<String, String> map);
}
