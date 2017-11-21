package com.gibsoncool.a07_retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.a07_retrofitdemo.api.GnakApi;
import com.gibsoncool.a07_retrofitdemo.api.GnakWithParmsApi;
import com.gibsoncool.a07_retrofitdemo.api.WeatherApi;
import com.gibsoncool.a07_retrofitdemo.api.WeatherFormApi;
import com.gibsoncool.a07_retrofitdemo.api.WeatherMapApi;
import com.gibsoncool.a07_retrofitdemo.api.WeatherObjectApi;
import com.gibsoncool.a07_retrofitdemo.bean.GnakBean;
import com.gibsoncool.a07_retrofitdemo.bean.QueryWeather;
import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

	@BindView(R.id.bt_send)
	Button       btSend;
	@BindView(R.id.tv_note)
	TextView     tvNote;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;
	@BindView(R.id.bt_weather)
	Button       btWeather;
	@BindView(R.id.bt_send_parms)
	Button       btSendParms;
	@BindView(R.id.bt_weather_map)
	Button       btWeatherMap;
	@BindView(R.id.bt_post_form)
	Button       btPostForm;
	@BindView(R.id.bt_post_object)
	Button       btPostObject;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick({R.id.bt_send, R.id.bt_weather, R.id.bt_send_parms, R.id.bt_weather_map, R.id.bt_post_form, R.id.bt_post_object})
	public void onViewClicked(View view)
	{
		switch (view.getId())
		{
			case R.id.bt_send:
				getGnakData();
				break;
			case R.id.bt_weather:
				getWeatherData();
				break;
			case R.id.bt_send_parms:
				getGnakDataWithParms();
				break;
			case R.id.bt_weather_map:
				getWeatherDataByMapParms();
				break;
			case R.id.bt_post_form:
				getWeatherDataByFormParms();
				break;
			case R.id.bt_post_object:
				getWeatherDataByObjectParms();
				break;
		}
	}

	private void getWeatherDataByObjectParms()
	{
		QueryWeather body = new QueryWeather();
		body.setCityname("深圳");
		body.setKey("936a1cbef07daea594a54a277feeb0f6");
		new Retrofit.Builder()
				.baseUrl("http://v.juhe.cn/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(WeatherObjectApi.class)
				.postObject(body)
				.enqueue(new Callback<WeatherGsonBean>()
				{
					@Override
					public void onResponse(Call<WeatherGsonBean> call, Response<WeatherGsonBean> response)
					{
						String result = null;

						result = response.body().getResultcode() + "   " + response.body().getReason();

						Log.i("cxxinfo", result);
						tvNote.setText("深圳天气:" + result);
					}

					@Override
					public void onFailure(Call<WeatherGsonBean> call, Throwable t)
					{
						tvNote.setText("请求出错:\n" + t.toString());
					}
				});
	}

	private void getWeatherDataByFormParms()
	{
		new Retrofit.Builder()
				.baseUrl("http://v.juhe.cn/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(WeatherFormApi.class)
				.postByForm("深圳", "936a1cbef07daea594a54a277feeb0f6")
				.enqueue(new Callback<WeatherGsonBean>()
				{
					@Override
					public void onResponse(Call<WeatherGsonBean> call, Response<WeatherGsonBean> response)
					{
						String result = null;

						result = response.body().getResultcode() + "   " + response.body().getReason();

						Log.i("cxxinfo", result);
						tvNote.setText("深圳天气:" + result);
					}

					@Override
					public void onFailure(Call<WeatherGsonBean> call, Throwable t)
					{
						tvNote.setText("请求出错:\n" + t.toString());
					}
				});
	}

	private void getWeatherData()
	{
		new Retrofit.Builder()
				.baseUrl("http://v.juhe.cn/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()    //retrofit对象
				.create(WeatherApi.class)        //WeatherApi对象
				.getWeather("936a1cbef07daea594a54a277feeb0f6")        //Call 对象
				.enqueue(new Callback<WeatherGsonBean>()
				{
					@Override
					public void onResponse(Call<WeatherGsonBean> call, Response<WeatherGsonBean> response)
					{
						String result = null;

						result = response.body().getResultcode() + "   " + response.body().getReason();

						Log.i("cxxinfo", result);
						tvNote.setText("深圳天气:" + result);

					}

					@Override
					public void onFailure(Call<WeatherGsonBean> call, Throwable t)
					{

					}
				});
	}

	public void getGnakData()
	{
		Retrofit retrofit2 = new Retrofit.Builder().baseUrl("http://gank.io").addConverterFactory(GsonConverterFactory.create()).build();

		GnakApi gnakApi = retrofit2.create(GnakApi.class);
		Call<GnakBean> call = gnakApi.getAndroidInfo();
		call.enqueue(new Callback<GnakBean>()
		{
			@Override
			public void onResponse(Call<GnakBean> call, Response<GnakBean> response)
			{
				String result = null;
				result = response.body().toString();

				Log.i("cxxinfo", result);
				tvNote.setText(response.body().getResults().get(0).getDesc());
			}

			@Override
			public void onFailure(Call<GnakBean> call, Throwable t)
			{

			}
		});
	}

	private void getGnakDataWithParms()
	{
		new Retrofit.Builder()
				.baseUrl("http://gank.io")
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(GnakWithParmsApi.class)
				.getInfo(2)
				.enqueue(new Callback<GnakBean>()
				{
					@Override
					public void onResponse(Call<GnakBean> call, Response<GnakBean> response)
					{
						String result = null;
						result = response.body().toString();

						Log.i("cxxinfo", result);
						tvNote.setText(response.body().getResults().get(0).getDesc());
					}

					@Override
					public void onFailure(Call<GnakBean> call, Throwable t)
					{

					}
				});
	}

	private void getWeatherDataByMapParms()
	{
		Map<String, String> parmas = new HashMap<>();
		parmas.put("key", "936a1cbef07daea594a54a277feeb0f6");
		parmas.put("cityname", "深圳");

		new Retrofit.Builder()
				.baseUrl("http://v.juhe.cn/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()    //retrofit对象
				.create(WeatherMapApi.class)        //WeatherApi对象
				.getWeather(parmas)        //Call 对象
				.enqueue(new Callback<WeatherGsonBean>()
				{
					@Override
					public void onResponse(Call<WeatherGsonBean> call, Response<WeatherGsonBean> response)
					{
						String result = null;

						result = response.body().getResultcode() + "   " + response.body().getReason();

						tvNote.setText("深圳天气:" + result);

					}

					@Override
					public void onFailure(Call<WeatherGsonBean> call, Throwable t)
					{

					}
				});

	}


}
