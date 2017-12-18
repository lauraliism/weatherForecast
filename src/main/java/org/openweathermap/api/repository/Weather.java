package org.openweathermap.api.repository;

import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequest;
import org.openweathermap.exception.NoWeatherReportException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public interface Weather {
	void getForecastsAndWriteToFile() throws IOException, NoWeatherReportException;

	Double getCurrentTemperature(WeatherRequest request) throws NoWeatherReportException;

	HashMap getThreeDaysHighestAndLowestTemp(WeatherRequest request) throws NoWeatherReportException;

	JSONObject getCityCoordinates(WeatherRequest request) throws NoWeatherReportException;
}
