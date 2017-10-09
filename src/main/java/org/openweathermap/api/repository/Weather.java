package org.openweathermap.api.repository;

import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public interface Weather {

	JSONObject getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException;

	JSONObject getHighestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	JSONObject getLowestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	JSONObject getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException;
}
