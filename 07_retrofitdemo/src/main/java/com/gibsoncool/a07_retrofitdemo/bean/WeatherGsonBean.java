package com.gibsoncool.a07_retrofitdemo.bean;

/**
 * Created by GibsonCool on 2017/11/17
 */
public class WeatherGsonBean
{
	/**
	 * resultcode : 200
	 * reason : successed!
	 * result : {"sk":{"temp":"25","wind_direction":"南风","wind_strength":"2级","humidity":"82%","time":"18:59"},"today":{"temperature":"18℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期五","city":"深圳","date_y":"2017年11月17日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"较适宜","travel_index":"较适宜","exercise_index":"较适宜","drying_index":""},"future":{"day_20171117":{"temperature":"18℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期五","date":"20171117"},"day_20171118":{"temperature":"16℃~25℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风微风","week":"星期六","date":"20171118"},"day_20171119":{"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期日","date":"20171119"},"day_20171120":{"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期一","date":"20171120"},"day_20171121":{"temperature":"13℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期二","date":"20171121"},"day_20171122":{"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期三","date":"20171122"},"day_20171123":{"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期四","date":"20171123"}}}
	 * error_code : 0
	 */

	private String resultcode;
	private String     reason;
	private ResultBean result;
	private int        error_code;

	public String getResultcode()
	{
		return resultcode;
	}

	public void setResultcode(String resultcode)
	{
		this.resultcode = resultcode;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public ResultBean getResult()
	{
		return result;
	}

	public void setResult(ResultBean result)
	{
		this.result = result;
	}

	public int getError_code()
	{
		return error_code;
	}

	public void setError_code(int error_code)
	{
		this.error_code = error_code;
	}

	public static class ResultBean
	{
		/**
		 * sk : {"temp":"25","wind_direction":"南风","wind_strength":"2级","humidity":"82%","time":"18:59"}
		 * today : {"temperature":"18℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期五","city":"深圳","date_y":"2017年11月17日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"较适宜","travel_index":"较适宜","exercise_index":"较适宜","drying_index":""}
		 * future : {"day_20171117":{"temperature":"18℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期五","date":"20171117"},"day_20171118":{"temperature":"16℃~25℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风微风","week":"星期六","date":"20171118"},"day_20171119":{"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期日","date":"20171119"},"day_20171120":{"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期一","date":"20171120"},"day_20171121":{"temperature":"13℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期二","date":"20171121"},"day_20171122":{"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期三","date":"20171122"},"day_20171123":{"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期四","date":"20171123"}}
		 */

		private SkBean sk;
		private TodayBean  today;
		private FutureBean future;

		public SkBean getSk()
		{
			return sk;
		}

		public void setSk(SkBean sk)
		{
			this.sk = sk;
		}

		public TodayBean getToday()
		{
			return today;
		}

		public void setToday(TodayBean today)
		{
			this.today = today;
		}

		public FutureBean getFuture()
		{
			return future;
		}

		public void setFuture(FutureBean future)
		{
			this.future = future;
		}

		public static class SkBean
		{
			/**
			 * temp : 25
			 * wind_direction : 南风
			 * wind_strength : 2级
			 * humidity : 82%
			 * time : 18:59
			 */

			private String temp;
			private String wind_direction;
			private String wind_strength;
			private String humidity;
			private String time;

			public String getTemp()
			{
				return temp;
			}

			public void setTemp(String temp)
			{
				this.temp = temp;
			}

			public String getWind_direction()
			{
				return wind_direction;
			}

			public void setWind_direction(String wind_direction)
			{
				this.wind_direction = wind_direction;
			}

			public String getWind_strength()
			{
				return wind_strength;
			}

			public void setWind_strength(String wind_strength)
			{
				this.wind_strength = wind_strength;
			}

			public String getHumidity()
			{
				return humidity;
			}

			public void setHumidity(String humidity)
			{
				this.humidity = humidity;
			}

			public String getTime()
			{
				return time;
			}

			public void setTime(String time)
			{
				this.time = time;
			}
		}

		public static class TodayBean
		{
			/**
			 * temperature : 18℃~28℃
			 * weather : 多云
			 * weather_id : {"fa":"01","fb":"01"}
			 * wind : 微风
			 * week : 星期五
			 * city : 深圳
			 * date_y : 2017年11月17日
			 * dressing_index : 热
			 * dressing_advice : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
			 * uv_index : 弱
			 * comfort_index :
			 * wash_index : 较适宜
			 * travel_index : 较适宜
			 * exercise_index : 较适宜
			 * drying_index :
			 */

			private String temperature;
			private String        weather;
			private WeatherIdBean weather_id;
			private String        wind;
			private String        week;
			private String        city;
			private String        date_y;
			private String        dressing_index;
			private String        dressing_advice;
			private String        uv_index;
			private String        comfort_index;
			private String        wash_index;
			private String        travel_index;
			private String        exercise_index;
			private String        drying_index;

			public String getTemperature()
			{
				return temperature;
			}

			public void setTemperature(String temperature)
			{
				this.temperature = temperature;
			}

			public String getWeather()
			{
				return weather;
			}

			public void setWeather(String weather)
			{
				this.weather = weather;
			}

			public WeatherIdBean getWeather_id()
			{
				return weather_id;
			}

			public void setWeather_id(WeatherIdBean weather_id)
			{
				this.weather_id = weather_id;
			}

			public String getWind()
			{
				return wind;
			}

			public void setWind(String wind)
			{
				this.wind = wind;
			}

			public String getWeek()
			{
				return week;
			}

			public void setWeek(String week)
			{
				this.week = week;
			}

			public String getCity()
			{
				return city;
			}

			public void setCity(String city)
			{
				this.city = city;
			}

			public String getDate_y()
			{
				return date_y;
			}

			public void setDate_y(String date_y)
			{
				this.date_y = date_y;
			}

			public String getDressing_index()
			{
				return dressing_index;
			}

			public void setDressing_index(String dressing_index)
			{
				this.dressing_index = dressing_index;
			}

			public String getDressing_advice()
			{
				return dressing_advice;
			}

			public void setDressing_advice(String dressing_advice)
			{
				this.dressing_advice = dressing_advice;
			}

			public String getUv_index()
			{
				return uv_index;
			}

			public void setUv_index(String uv_index)
			{
				this.uv_index = uv_index;
			}

			public String getComfort_index()
			{
				return comfort_index;
			}

			public void setComfort_index(String comfort_index)
			{
				this.comfort_index = comfort_index;
			}

			public String getWash_index()
			{
				return wash_index;
			}

			public void setWash_index(String wash_index)
			{
				this.wash_index = wash_index;
			}

			public String getTravel_index()
			{
				return travel_index;
			}

			public void setTravel_index(String travel_index)
			{
				this.travel_index = travel_index;
			}

			public String getExercise_index()
			{
				return exercise_index;
			}

			public void setExercise_index(String exercise_index)
			{
				this.exercise_index = exercise_index;
			}

			public String getDrying_index()
			{
				return drying_index;
			}

			public void setDrying_index(String drying_index)
			{
				this.drying_index = drying_index;
			}

			public static class WeatherIdBean
			{
				/**
				 * fa : 01
				 * fb : 01
				 */

				private String fa;
				private String fb;

				public String getFa()
				{
					return fa;
				}

				public void setFa(String fa)
				{
					this.fa = fa;
				}

				public String getFb()
				{
					return fb;
				}

				public void setFb(String fb)
				{
					this.fb = fb;
				}
			}
		}

		public static class FutureBean
		{
			/**
			 * day_20171117 : {"temperature":"18℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期五","date":"20171117"}
			 * day_20171118 : {"temperature":"16℃~25℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风微风","week":"星期六","date":"20171118"}
			 * day_20171119 : {"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期日","date":"20171119"}
			 * day_20171120 : {"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期一","date":"20171120"}
			 * day_20171121 : {"temperature":"13℃~20℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期二","date":"20171121"}
			 * day_20171122 : {"temperature":"14℃~19℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"东北风3-4 级","week":"星期三","date":"20171122"}
			 * day_20171123 : {"temperature":"13℃~18℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"微风","week":"星期四","date":"20171123"}
			 */

			private Day20171117Bean day_20171117;
			private Day20171118Bean day_20171118;
			private Day20171119Bean day_20171119;
			private Day20171120Bean day_20171120;
			private Day20171121Bean day_20171121;
			private Day20171122Bean day_20171122;
			private Day20171123Bean day_20171123;

			public Day20171117Bean getDay_20171117()
			{
				return day_20171117;
			}

			public void setDay_20171117(Day20171117Bean day_20171117)
			{
				this.day_20171117 = day_20171117;
			}

			public Day20171118Bean getDay_20171118()
			{
				return day_20171118;
			}

			public void setDay_20171118(Day20171118Bean day_20171118)
			{
				this.day_20171118 = day_20171118;
			}

			public Day20171119Bean getDay_20171119()
			{
				return day_20171119;
			}

			public void setDay_20171119(Day20171119Bean day_20171119)
			{
				this.day_20171119 = day_20171119;
			}

			public Day20171120Bean getDay_20171120()
			{
				return day_20171120;
			}

			public void setDay_20171120(Day20171120Bean day_20171120)
			{
				this.day_20171120 = day_20171120;
			}

			public Day20171121Bean getDay_20171121()
			{
				return day_20171121;
			}

			public void setDay_20171121(Day20171121Bean day_20171121)
			{
				this.day_20171121 = day_20171121;
			}

			public Day20171122Bean getDay_20171122()
			{
				return day_20171122;
			}

			public void setDay_20171122(Day20171122Bean day_20171122)
			{
				this.day_20171122 = day_20171122;
			}

			public Day20171123Bean getDay_20171123()
			{
				return day_20171123;
			}

			public void setDay_20171123(Day20171123Bean day_20171123)
			{
				this.day_20171123 = day_20171123;
			}

			public static class Day20171117Bean
			{
				/**
				 * temperature : 18℃~28℃
				 * weather : 多云
				 * weather_id : {"fa":"01","fb":"01"}
				 * wind : 微风
				 * week : 星期五
				 * date : 20171117
				 */

				private String temperature;
				private String         weather;
				private WeatherIdBeanX weather_id;
				private String         wind;
				private String         week;
				private String         date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanX
				{
					/**
					 * fa : 01
					 * fb : 01
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171118Bean
			{
				/**
				 * temperature : 16℃~25℃
				 * weather : 小雨
				 * weather_id : {"fa":"07","fb":"07"}
				 * wind : 东北风微风
				 * week : 星期六
				 * date : 20171118
				 */

				private String temperature;
				private String          weather;
				private WeatherIdBeanXX weather_id;
				private String          wind;
				private String          week;
				private String          date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXX
				{
					/**
					 * fa : 07
					 * fb : 07
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171119Bean
			{
				/**
				 * temperature : 14℃~19℃
				 * weather : 小雨
				 * weather_id : {"fa":"07","fb":"07"}
				 * wind : 东北风3-4 级
				 * week : 星期日
				 * date : 20171119
				 */

				private String temperature;
				private String           weather;
				private WeatherIdBeanXXX weather_id;
				private String           wind;
				private String           week;
				private String           date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXXX
				{
					/**
					 * fa : 07
					 * fb : 07
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171120Bean
			{
				/**
				 * temperature : 13℃~18℃
				 * weather : 小雨转阴
				 * weather_id : {"fa":"07","fb":"02"}
				 * wind : 微风
				 * week : 星期一
				 * date : 20171120
				 */

				private String temperature;
				private String            weather;
				private WeatherIdBeanXXXX weather_id;
				private String            wind;
				private String            week;
				private String            date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXXXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXXXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXXXX
				{
					/**
					 * fa : 07
					 * fb : 02
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171121Bean
			{
				/**
				 * temperature : 13℃~20℃
				 * weather : 阴转多云
				 * weather_id : {"fa":"02","fb":"01"}
				 * wind : 微风
				 * week : 星期二
				 * date : 20171121
				 */

				private String temperature;
				private String             weather;
				private WeatherIdBeanXXXXX weather_id;
				private String             wind;
				private String             week;
				private String             date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXXXXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXXXXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXXXXX
				{
					/**
					 * fa : 02
					 * fb : 01
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171122Bean
			{
				/**
				 * temperature : 14℃~19℃
				 * weather : 小雨
				 * weather_id : {"fa":"07","fb":"07"}
				 * wind : 东北风3-4 级
				 * week : 星期三
				 * date : 20171122
				 */

				private String temperature;
				private String              weather;
				private WeatherIdBeanXXXXXX weather_id;
				private String              wind;
				private String              week;
				private String              date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXXXXXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXXXXXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXXXXXX
				{
					/**
					 * fa : 07
					 * fb : 07
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}

			public static class Day20171123Bean
			{
				/**
				 * temperature : 13℃~18℃
				 * weather : 小雨转阴
				 * weather_id : {"fa":"07","fb":"02"}
				 * wind : 微风
				 * week : 星期四
				 * date : 20171123
				 */

				private String temperature;
				private String               weather;
				private WeatherIdBeanXXXXXXX weather_id;
				private String               wind;
				private String               week;
				private String               date;

				public String getTemperature()
				{
					return temperature;
				}

				public void setTemperature(String temperature)
				{
					this.temperature = temperature;
				}

				public String getWeather()
				{
					return weather;
				}

				public void setWeather(String weather)
				{
					this.weather = weather;
				}

				public WeatherIdBeanXXXXXXX getWeather_id()
				{
					return weather_id;
				}

				public void setWeather_id(WeatherIdBeanXXXXXXX weather_id)
				{
					this.weather_id = weather_id;
				}

				public String getWind()
				{
					return wind;
				}

				public void setWind(String wind)
				{
					this.wind = wind;
				}

				public String getWeek()
				{
					return week;
				}

				public void setWeek(String week)
				{
					this.week = week;
				}

				public String getDate()
				{
					return date;
				}

				public void setDate(String date)
				{
					this.date = date;
				}

				public static class WeatherIdBeanXXXXXXX
				{
					/**
					 * fa : 07
					 * fb : 02
					 */

					private String fa;
					private String fb;

					public String getFa()
					{
						return fa;
					}

					public void setFa(String fa)
					{
						this.fa = fa;
					}

					public String getFb()
					{
						return fb;
					}

					public void setFb(String fb)
					{
						this.fb = fb;
					}
				}
			}
		}
	}
}
