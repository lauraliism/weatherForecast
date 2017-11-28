package org.openweathermap.api.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.exception.NoWeatherReportException;

import java.io.IOException;
import java.text.SimpleDateFormat;

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

	public JSONArray getWeatherForecast(WeatherRequestForecast request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getWeatherForecastURL(request);
			final String response = httpRequest.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONArray list = JSONresponse.getJSONArray("list");

			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = timeFormat.format(System.currentTimeMillis());
			System.out.println("currentTime " + currentDate);

			for (int i=0; i < list.length(); i++) {
				JSONObject object = list.getJSONObject(i);
				// System.out.println("Object!!! " + object);
				String forecast = object.getString("dt_txt");
				String forecastDate = forecast.substring(0, forecast.indexOf(" "));
				System.out.println("forecastDate " + forecastDate);

				if (forecastDate.equals(currentDate)) {
					System.out.println("SAMAD!!!");
				}

				// JSONObject main = object.getJSONObject("main");
				// Double tempMin = main.getDouble("temp_min");
				// Double tempMax = main.getDouble("temp_max");

				// System.out.println("tempMin "+ tempMin);
				// System.out.println("tempMax " + tempMax);
			}
			return list;
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
