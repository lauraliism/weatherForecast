package org.openweathermap.api.models.report;

import org.openweathermap.api.models.report.model.Coordinates;
import org.openweathermap.api.models.report.model.DailyWeather;
import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class WeatherReportForecast extends WeatherReport {
	public final DailyWeather[] weatherForecast;

	public WeatherReportForecast(String cityName, Constants.UNIT units, Coordinates geoCoordinates, DailyWeather[] weatherForecast) {
		super(cityName, units, geoCoordinates);
		this.weatherForecast = weatherForecast;
	}

}
