package org.openweathermap.api.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.exception.NoWeatherReportException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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

	private String getCurrentDate() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = timeFormat.format(System.currentTimeMillis());
		System.out.println("currentDate " + currentDate);
		return currentDate;
	}

	private String getObjectDate(JSONObject object) {
		String forecast = object.getString("dt_txt");
		String forecastDate = forecast.substring(0, forecast.indexOf(" "));
		return forecastDate;
	}

	public HashMap<String, Object> getThreeDaysHighestAndLowestTemp(WeatherRequestForecast request) throws NoWeatherReportException {
		try {
			String requestUrl = httpRequest.getWeatherForecastURL(request);
			final String response = httpRequest.makeApiRequest(requestUrl);

			JSONObject JSONresponse = new JSONObject(response);
			JSONArray list = JSONresponse.getJSONArray("list");
			String currentDate = this.getCurrentDate();

			HashMap<String, Object> temperatures = new HashMap<String,Object>();
			ArrayList <Double> dailyTemperatures = new ArrayList<Double>();

			for (int i=0; i < list.length(); i++) {
				JSONObject object = list.getJSONObject(i);
				String forecastDate = this.getObjectDate(object);
				if (!forecastDate.equals(currentDate) && (!list.isNull(i+1) && getObjectDate(list.getJSONObject(i+1)).equals(forecastDate))) {

					JSONObject main = object.getJSONObject("main");
					Double tempMin = main.getDouble("temp_min");
					Double tempMax = main.getDouble("temp_max");
					dailyTemperatures.add(tempMin);
					dailyTemperatures.add(tempMax);

				}
				else if (!forecastDate.equals(currentDate) && (list.isNull(i+1) || !(getObjectDate(list.getJSONObject(i+1)).equals(forecastDate)))) {
					JSONObject main = object.getJSONObject("main");
					Double tempMin = main.getDouble("temp_min");
					Double tempMax = main.getDouble("temp_max");
					dailyTemperatures.add(tempMin);
					dailyTemperatures.add(tempMax);

					Double dailyTempMax = Collections.max(dailyTemperatures);
					Double dailyTempMin = Collections.min(dailyTemperatures);
					ArrayList <Double> dailyMinAndMaxTemp = new ArrayList<Double>();
					dailyMinAndMaxTemp.add(dailyTempMax);
					dailyMinAndMaxTemp.add(dailyTempMin);

					if (temperatures.size() < 3) {
						temperatures.put(forecastDate, dailyMinAndMaxTemp.clone());
					}

					dailyTemperatures.clear();
					dailyMinAndMaxTemp.clear();
				}
			}
			return temperatures;
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
