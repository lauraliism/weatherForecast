package org.openweathermap.api.repository;

import okhttp3.HttpUrl;
import org.openweathermap.api.request.WeatherRequestCurrent;
import org.openweathermap.api.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

import java.net.URL;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public class WeatherForecastRepository implements Weather {

	public URL getCurrentWeatherRequestURL(WeatherRequestCurrent request) {
		URL requestURL = new HttpUrl.Builder()
			.scheme("https")
			.host("api.openweathermap.org")
			.addPathSegment("/data/2.5/weather")
			.addQueryParameter("q", request.countryCode+","+request.cityName)
			.addQueryParameter("APPID", request.apiKey)
			.build().url();
		System.out.println(requestURL);
		return requestURL;
	}

	public static URL getWeatherForecastURL(WeatherRequestForecast request) {
		int forecastLength = request.forecastLengthInDays;
		URL requestURL = new HttpUrl.Builder()
				.scheme("https")
				.host("api.openweathermap.org")
				.addPathSegment("/data/2.5/weather")
				.addQueryParameter("q", request.countryCode+","+request.cityName)
				.addQueryParameter("APPID", request.apiKey)
				.addQueryParameter("cnt", String.valueOf(forecastLength))
				.build().url();
		return requestURL;
	}


	public void getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException {

	}

	public void getHighestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException {

	}

	public void getLowestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException {

	}

	public void getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException {

	}
}
