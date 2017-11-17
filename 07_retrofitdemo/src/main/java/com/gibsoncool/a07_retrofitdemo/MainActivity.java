package com.gibsoncool.a07_retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gibsoncool.a07_retrofitdemo.api.GnakApi;
import com.gibsoncool.a07_retrofitdemo.api.WeatherApi;
import com.gibsoncool.a07_retrofitdemo.bean.GnakBean;
import com.gibsoncool.a07_retrofitdemo.bean.WeatherGsonBean;

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

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	private void getWeatherData()
	{
		new Retrofit.Builder()
				.baseUrl("http://v.juhe.cn/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(WeatherApi.class)
				.getWeather("936a1cbef07daea594a54a277feeb0f6")
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
				tvNote.setText(result);
			}

			@Override
			public void onFailure(Call<GnakBean> call, Throwable t)
			{

			}
		});
	}

	@OnClick({R.id.bt_send, R.id.bt_weather})
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
		}
	}


}
