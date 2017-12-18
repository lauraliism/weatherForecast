package org.openweathermap.api.models.request;

import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestForecast extends WeatherRequest{
	public final int forecastLengthInDays;

	public WeatherRequestForecast(String cityName, int forecastLengthInDays, String apiKey, Constants.UNIT units) {
		super(cityName, apiKey, units);
		this.forecastLengthInDays = forecastLengthInDays;
	}
}
