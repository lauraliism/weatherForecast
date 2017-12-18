package org.openweathermap.api.models.request;

import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestForecast extends WeatherRequest{

	public WeatherRequestForecast(String cityName, String apiKey, Constants.UNIT units) {
		super(cityName, apiKey, units);
	}
}
