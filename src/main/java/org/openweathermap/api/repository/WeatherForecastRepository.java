package org.openweathermap.api.repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openweathermap.api.console.ConsoleController;
import org.openweathermap.api.console.FileController;
import org.openweathermap.api.models.request.WeatherRequest;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.api.utility.constants.Constants;
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
	public String APPID = "db1fb1d0d306a8dedfc165d671dd5e4d";
	Constants.UNIT UNITS = Constants.UNIT.metric;
	HttpUtility utility = new HttpUtility();

	public void getForecastsAndWriteToFile() throws IOException, NoWeatherReportException, JSONException {
		ConsoleController consoleController = new ConsoleController();
		FileController fileController = new FileController();
		ArrayList<String> cities = consoleController.getCityNames();
		for (String city : cities) {
			ArrayList<String> cityResponse = new ArrayList<>();
			WeatherRequest request = new WeatherRequest(city, APPID, UNITS);
			Double currentTemperature = this.getCurrentTemperature(request);
			HashMap threeDaysMinAndMaxTemperatures = this.getThreeDaysHighestAndLowestTemp(request);
			JSONObject coordinates = this.getCityCoordinates(request);

			cityResponse.add(threeDaysMinAndMaxTemperatures.toString());
			cityResponse.add(coordinates.toString());
			fileController.writeResultsToFile(city, currentTemperature.toString(), cityResponse);
		}
		System.out.println("You may find the results from resources folder!");
	}

	public Double getCurrentTemperature(WeatherRequest request) throws NoWeatherReportException, IOException, JSONException {
			String requestUrl = utility.getCurrentWeatherRequestURL(request);
			final String response = utility.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONObject main = JSONresponse.getJSONObject("main");
			Double temperature = main.getDouble("temp");
			return temperature;
	}

	private String getCurrentDate() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = timeFormat.format(System.currentTimeMillis());
		return currentDate;
	}

	private String getObjectDate(JSONObject object) throws JSONException {
		String forecast = object.getString("dt_txt");
		String forecastDate = forecast.substring(0, forecast.indexOf(" "));
		return forecastDate;
	}

	private JSONArray getForecastList(WeatherRequest request) throws IOException, JSONException {
		String requestUrl = utility.getWeatherForecastURL(request);
		final String response = utility.makeApiRequest(requestUrl);

		JSONObject JSONresponse = new JSONObject(response);
		JSONArray list = JSONresponse.getJSONArray("list");
		return list;
	}

	private Double getHighestOrLowestTemp(Boolean highest, ArrayList <Double> dailyTemperatures) {
		if (highest) {
			return Collections.max(dailyTemperatures);
		} else {
			return Collections.min(dailyTemperatures);
		}
	}

	private JSONObject getMinAndMaxTempFromObject(JSONObject object) throws JSONException {
		JSONObject temperatures = new JSONObject();

		JSONObject main = object.getJSONObject("main");
		Double tempMin = main.getDouble("temp_min");
		Double tempMax = main.getDouble("temp_max");

		temperatures.put("tempMin", tempMin);
		temperatures.put("tempMax", tempMax);
		return temperatures;
	}

	public HashMap<String, Object> getThreeDaysHighestAndLowestTemp(WeatherRequest request) throws NoWeatherReportException, JSONException {
		try {
			JSONArray list = this.getForecastList(request);
			String currentDate = this.getCurrentDate();

			HashMap<String, Object> temperatures = new HashMap<String,Object>();
			ArrayList <Double> dailyTemperatures = new ArrayList<Double>();

			for (int i=0; i < list.length(); i++) {
				JSONObject object = list.getJSONObject(i);
				String forecastDate = this.getObjectDate(object);
				if (!forecastDate.equals(currentDate) && (!list.isNull(i+1) && getObjectDate(list.getJSONObject(i+1)).equals(forecastDate))) {

					JSONObject minAndMaxTemp = this.getMinAndMaxTempFromObject(object);
					dailyTemperatures.add(minAndMaxTemp.getDouble("tempMin"));
					dailyTemperatures.add(minAndMaxTemp.getDouble("tempMax"));
				}
				else if (!forecastDate.equals(currentDate) && (list.isNull(i+1) || !(getObjectDate(list.getJSONObject(i+1)).equals(forecastDate)))) {

					JSONObject minAndMaxTemp = this.getMinAndMaxTempFromObject(object);
					dailyTemperatures.add(minAndMaxTemp.getDouble("tempMin"));
					dailyTemperatures.add(minAndMaxTemp.getDouble("tempMax"));

					ArrayList <Double> dailyMinAndMaxTemp = new ArrayList<Double>();
					dailyMinAndMaxTemp.add(getHighestOrLowestTemp(true, dailyTemperatures));
					dailyMinAndMaxTemp.add(getHighestOrLowestTemp(false, dailyTemperatures));

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

	public JSONObject getCityCoordinates(WeatherRequest request) throws NoWeatherReportException, JSONException {
		String requestUrl = utility.getCurrentWeatherRequestURL(request).toString();
		final String response;
		try {
			response = utility.makeApiRequest(requestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONObject coordinates = JSONresponse.getJSONObject("coord");
			return coordinates;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}

	public JSONObject getCityCoordinates2(String currentWeatherRequestUrl, HttpUtility utility) throws NoWeatherReportException, JSONException {
		try {
			// String requestUrl = utility.getCurrentWeatherRequestURL(request).toString();
			final String response;
			response = utility.makeApiRequest(currentWeatherRequestUrl);
			JSONObject JSONresponse = new JSONObject(response);
			JSONObject coordinates = JSONresponse.getJSONObject("coord");
			System.out.println(coordinates);
			return coordinates;
		} catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		throw new NoWeatherReportException("Error!");
	}
}
