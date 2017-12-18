package org.openweathermap.api.utility;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openweathermap.api.models.request.WeatherRequest;

import java.io.IOException;
import java.net.URL;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class HttpUtility implements URLBuilder {

	OkHttpClient client = new OkHttpClient();

	public String getCurrentWeatherRequestURL(WeatherRequest request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.cityName)
				.addQueryParameter("units", String.valueOf(request.units))
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL.toString();
	}

	public String getWeatherForecastURL(WeatherRequest request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/forecast")
				.addQueryParameter("q", request.cityName)
				.addQueryParameter("units", String.valueOf(request.units))
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL.toString();
	}

	public String makeApiRequest(String url) throws IOException {
		Request request = new Request.Builder()
			.url(url)
			.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
