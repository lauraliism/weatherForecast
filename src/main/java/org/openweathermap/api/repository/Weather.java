package org.openweathermap.api.repository;

import org.json.JSONObject;
import org.openweathermap.api.request.WeatherRequestCurrent;
import org.openweathermap.api.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

import java.net.URL;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public interface Weather {
	URL getCurrentWeatherRequestURL(WeatherRequestCurrent request) throws NoWeatherReportException;

	JSONObject getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException;

	JSONObject getHighestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	JSONObject getLowestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	JSONObject getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException;
}
