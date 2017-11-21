package com.gibsoncool.a07_retrofitdemo.bean;

/**
 * Created by GibsonCool on 2017/11/21
 */

public class QueryWeather
{
	private String cityname;
	private String key;

	public String getCityname()
	{
		return cityname;
	}

	public void setCityname(String cityname)
	{
		this.cityname = cityname;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}
}
