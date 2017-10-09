package org.openweathermap.api.models.report;

import org.openweathermap.api.models.report.model.Coordinates;
import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class WeatherReportCurrent extends WeatherReport {
	public final float currentTemp;

	public WeatherReportCurrent(String cityName, Constants.UNIT units, Coordinates geoCoordinates, float currentTemp) {
		super(cityName, units, geoCoordinates);
		this.currentTemp = currentTemp;
	}
}
