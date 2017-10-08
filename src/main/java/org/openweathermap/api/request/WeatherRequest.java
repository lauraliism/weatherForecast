package org.openweathermap.api.request;

/**
 * Created by lauraliismetsvaht on 08/10/2017.
 */
public class WeatherRequest {
	public final String cityName;
	public final String countryCode;
	public final String apiKey;

	public WeatherRequest(String cityName, String countryCode, String apiKey) {
		this.cityName = cityName;
		this.countryCode = countryCode;
		this.apiKey = apiKey;
	}
}
