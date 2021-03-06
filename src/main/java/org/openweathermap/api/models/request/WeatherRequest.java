package org.openweathermap.api.models.request;

import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequest {
	public final String cityName;
	public final String apiKey;
	public final Constants.UNIT units;

	public WeatherRequest(String cityName, String apiKey, Constants.UNIT units) {
		this.cityName = cityName;
		this.apiKey = apiKey;
		this.units = units;
	}
}
