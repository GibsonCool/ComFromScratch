package com.gibsoncool.a06_okhttpdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{


	@BindView(R.id.tv_note)
	TextView       tvNote;
	@BindView(R.id.bt_get_Asyn)
	Button         btGetAsyn;
	@BindView(R.id.bt_get_Sync)
	Button         btGetSync;
	@BindView(R.id.bt_post)
	Button         btPost;
	@BindView(R.id.bt_cache)
	Button         btCache;
	@BindView(R.id.activity_main)
	RelativeLayout activityMain;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			String detail = (String) msg.obj;
			tvNote.setText(detail);
		}
	};


	@OnClick({R.id.bt_get_Asyn, R.id.bt_get_Sync, R.id.bt_post, R.id.bt_cache})
	public void onViewClicked(View view)
	{
		switch (view.getId())
		{
			case R.id.bt_get_Asyn:
				getHttpByGetAsyn();
				break;
			case R.id.bt_get_Sync:
				try
				{
					getSyncHttp();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				break;
			case R.id.bt_post:
				getPostAsynHttp();
				break;
			case R.id.bt_cache:
				getGetByCache();
				break;
		}
	}

	private void getGetByCache()
	{

		OkHttpClient client = new OkHttpClient();
		final File externalCacheDir = getExternalCacheDir();
		int cacheSize = 10 * 1024 * 1024;
		client.setCache(new Cache(externalCacheDir, cacheSize));

		Request request = new Request.Builder()
				.url("http://www.jianshu.com/p/308f3c54abdd")
				.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback()
		{
			@Override
			public void onFailure(Request request, final IOException e)
			{
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						tvNote.setText("get error********cache path:" + externalCacheDir.getPath() + "\n" + e.toString());
					}
				});
			}

			@Override
			public void onResponse(final Response response) throws IOException
			{

				if (null != response.cacheResponse())
				{
					final String str = response.cacheResponse().toString();
					Log.i("cxxinfo", "cache---" + str);
					runOnUiThread(new Runnable()
					{
						@Override
						public void run()
						{
							tvNote.setText("cache---" + str);
						}
					});
				}
				else
				{
					try
					{
						response.body().string();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					final String str = response.networkResponse().toString();
					Log.i("cxxinfo", "network---" + str);
					runOnUiThread(new Runnable()
					{
						@Override
						public void run()
						{
							tvNote.setText("network---" + str);
						}
					});
				}

			}
		});
	}

	private void getPostAsynHttp()
	{
		/**
		 * 拉取数字阅读信息，排行榜内容数据
		 */
		OkHttpClient client = new OkHttpClient();


		RequestBody body = new FormEncodingBuilder()
				.add("contentType", "1")
				.add("rankType", "1")
				.add("rankTime", "1")
				.add("start", "0")
				.add("count", "10")
				.add("key", "1a54713b10681c12651dde7cb39932cc")
				.build();
		Request request = new Request.Builder()
				.url("http://japi.juhe.cn/rank/getRankInfo")
				.post(body)
				.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback()
		{
			@Override
			public void onFailure(Request request, final IOException e)
			{
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						tvNote.setText("post error********" + "\n" + e.toString());
					}
				});
			}

			@Override
			public void onResponse(Response response) throws IOException
			{
				final String string = response.body().string();
				Log.e("cxxinfo", "是否运行在主线程" + (Looper.getMainLooper().getThread() == Thread.currentThread()) + "\n" + string);
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						tvNote.setText("post ********" + "\n" + string);
					}
				});
			}
		});
	}

	private void getHttpByGetAsyn()
	{


		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://github.com/GibsonCool/ComFromScratch/blob/master/README.md")
				.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback()
		{
			@Override
			public void onFailure(Request request, IOException e)
			{
				tvNote.setText(e.toString());
			}

			@Override
			public void onResponse(final Response response) throws IOException
			{
				final String string = response.body().string();
				Log.e("cxxinfo", "是否运行在主线程" + (Looper.getMainLooper().getThread() == Thread.currentThread()) + "\n" + string);
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						tvNote.setText("get ********" + string);
					}
				});
			}
		});

	}


	private void getSyncHttp() throws IOException
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{

					OkHttpClient mOkHttpClient = new OkHttpClient();
					//创建请求Request
					final Request request = new Request.Builder()
							.url("https://github.com/GibsonCool/ComFromScratch/blob/master/README.md")
							.build();
					Call call = mOkHttpClient.newCall(request);
					Response mResponse = call.execute();

					String detail = mResponse.body().string();
					Log.e("cxxinfo", detail);
					Message message = new Message();
					message.obj = detail;
					handler.sendMessage(message);

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
}
