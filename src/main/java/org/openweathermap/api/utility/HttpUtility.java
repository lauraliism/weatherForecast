package org.openweathermap.api.utility;

import okhttp3.*;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;

import java.io.IOException;
import java.net.URL;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class HttpUtility {

	OkHttpClient client = new OkHttpClient();

	public URL getCurrentWeatherRequestURL(WeatherRequestCurrent request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.countryCode+","+request.cityName)
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL;
	}

	public URL getWeatherForecastURL(WeatherRequestForecast request) {
		int forecastLength = request.forecastLengthInDays;
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.countryCode+","+request.cityName)
				.addQueryParameter("appid", request.apiKey)
				.addQueryParameter("cnt", String.valueOf(forecastLength))
				.build().url();
		return requestURL;
	}

	public String makeApiRequest(String url) throws IOException {
		Request request = new Request.Builder()
			.url(url)
			.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
