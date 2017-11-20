package org.openweathermap.api.utility;

import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;

import java.io.IOException;

/**
 * Created by lauraliismetsvaht on 19/11/2017.
 */
public interface URLBuilder {
	String getCurrentWeatherRequestURL(WeatherRequestCurrent request);
	String getWeatherForecastURL(WeatherRequestForecast request);
	String makeApiRequest(String url) throws IOException;
}
