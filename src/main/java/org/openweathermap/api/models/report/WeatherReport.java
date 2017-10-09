package org.openweathermap.api.models.report;

import org.openweathermap.api.models.report.model.Coordinates;
import org.openweathermap.api.utility.constants.Constants;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class WeatherReport {

	public final String cityName;
	public final Constants.UNIT units;
	public final Coordinates geoCoordinates;

	public WeatherReport(String cityName, Constants.UNIT units, Coordinates geoCoordinates) {
		this.cityName = cityName;
		this.units = units;
		this.geoCoordinates = geoCoordinates;
	}

}
