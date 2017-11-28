import org.json.JSONObject;
import org.junit.Test;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.repository.WeatherForecastRepository;
import org.openweathermap.api.utility.constants.Constants;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by lauraliismetsvaht on 11/09/2017.
 */
public class WeatherForecastRepositoryTest {

	String mockCityName = "Tartu";
	String mockCountryCode = "EE";
	int mockForecastLengthInDays = 3;
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";
	Constants.UNIT units = Constants.UNIT.metric;

	@Test
	public void doesGetCurrentTemperatureReturnTemperature() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			Double response = repository.getCurrentTemperature(request);
			System.out.println(response);
			assertEquals(response, instanceOf(Double.class));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetWeatherForecastReturnJSONobject() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getWeatherForecast(request);
			assertEquals(response, instanceOf(JSONObject.class));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetHighestTemperatureForLastThreeDaysReturnForecastOfMultipleDays() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getHighestTemperatureForLastThreeDays(request);
			assertEquals(true, response.has("cnt"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void getReturnLowestTemperatureForLastThreeDaysDoesReturnForecastOfThreeDays() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getLowestTemperatureForLastThreeDays(request);
			assertTrue(response.has("cnt") && response.get("cnt").equals(3));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getCityCoordinates(request);
			assertEquals(response, instanceOf(JSONObject.class));
			assertEquals(true, response.has("coord"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

}
