package org.openweathermap.api.repository;

import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

import java.util.HashMap;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public interface Weather {

	Double getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException;

	HashMap getThreeDaysHighestAndLowestTemp(WeatherRequestForecast request) throws NoWeatherReportException;

	JSONObject getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException;
}
