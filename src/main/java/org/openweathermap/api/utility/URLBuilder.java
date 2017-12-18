package org.openweathermap.api.utility;

import org.openweathermap.api.models.request.WeatherRequest;

import java.io.IOException;

/**
 * Created by lauraliismetsvaht on 19/11/2017.
 */
public interface URLBuilder {
	String getCurrentWeatherRequestURL(WeatherRequest request);
	String getWeatherForecastURL(WeatherRequest request);
	String makeApiRequest(String url) throws IOException;
}
