package org.openweathermap.api.models.request;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequestCurrent extends WeatherRequest {

	public WeatherRequestCurrent (String cityName, String countryCode, String apiKey) {
		super(cityName, countryCode, apiKey);
	}
}
