package org.openweathermap.api.repository;

import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.exception.NoWeatherReportException;

import java.io.IOException;

/**
 * Created by lauraliismetsvaht on 25/09/2017.
 */
public class WeatherForecastRepository implements Weather {

	HttpUtility httpRequest = new HttpUtility();

	public Double getCurrentTemperature(WeatherRequestCurrent request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getCurrentWeatherRequestURL(request);
			final String response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONObject main = JSONresponse.getJSONObject("main");
			Double temperature = main.getDouble("temp");
			return temperature;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}

	public JSONObject getWeatherForecast(WeatherRequestForecast request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getWeatherForecastURL(request).toString();
			final String response;
			response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}

	public JSONObject getHighestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getWeatherForecastURL(request).toString();
			final String response;
			response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}

	public JSONObject getLowestTemperatureForLastThreeDays(WeatherRequestForecast request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getWeatherForecastURL(request).toString();
			final String response;
			response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			return JSONresponse;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}

	public JSONObject getCityCoordinates(WeatherRequestCurrent request) throws NoWeatherReportException {
		String requestUrl = httpRequest.getCurrentWeatherRequestURL(request).toString();
		final String response;
		try {
			response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONObject coordinates = JSONresponse.getJSONObject("coord");
			return coordinates;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}
}
