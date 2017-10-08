package org.openweathermap.api.request;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestForecast extends WeatherRequest{
	public final int forecastLengthInDays;

	public WeatherRequestForecast(String cityName, String countryCode, int forecastLengthInDays, String apiKey) {
		super(cityName, countryCode, apiKey);
		this.forecastLengthInDays = forecastLengthInDays;
	}
}
