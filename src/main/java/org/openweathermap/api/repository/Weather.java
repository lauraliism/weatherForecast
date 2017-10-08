package org.openweathermap.api.repository;

import org.openweathermap.api.request.WeatherRequestCurrent;
import org.openweathermap.api.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

import java.net.URL;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public interface Weather {
	URL getCurrentWeatherRequestURL(WeatherRequestCurrent request) throws NoWeatherReportException;

	void getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException;

	void getHighestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	void getLowestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException;

	void getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException;
}
