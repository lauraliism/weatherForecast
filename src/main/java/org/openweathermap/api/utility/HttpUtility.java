package org.openweathermap.api.utility;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;

import java.io.IOException;
import java.net.URL;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class HttpUtility implements URLBuilder {

	OkHttpClient client = new OkHttpClient();

	public String getCurrentWeatherRequestURL(WeatherRequestCurrent request) {
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.cityName+", "+request.countryCode)
				.addQueryParameter("appid", request.apiKey)
				.build().url();
		return requestURL.toString();
	}

	public String getWeatherForecastURL(WeatherRequestForecast request) {
		int forecastLength = request.forecastLengthInDays;
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.cityName+", "+request.countryCode)
				.addQueryParameter("appid", request.apiKey)
				.addQueryParameter("cnt", String.valueOf(forecastLength))
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
