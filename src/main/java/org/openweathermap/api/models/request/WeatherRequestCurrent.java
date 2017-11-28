package org.openweathermap.api.models.request;

import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestCurrent extends WeatherRequest {

	public WeatherRequestCurrent (String cityName, String countryCode, String apiKey, Constants.UNIT units) {
		super(cityName, countryCode, apiKey, units);
	}
}
