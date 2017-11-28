package org.openweathermap.api.models.request;

import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestForecast extends WeatherRequest{
	public final int forecastLengthInDays;

	public WeatherRequestForecast(String cityName, String countryCode, int forecastLengthInDays, String apiKey, Constants.UNIT units) {
		super(cityName, countryCode, apiKey, units);
		this.forecastLengthInDays = forecastLengthInDays;
	}
}
