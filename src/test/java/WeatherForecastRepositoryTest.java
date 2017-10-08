import org.json.JSONObject;
import org.junit.Test;
import org.openweathermap.api.repository.WeatherForecastRepository;
import org.openweathermap.api.request.WeatherRequestCurrent;
import org.openweathermap.api.request.WeatherRequestForecast;

import java.net.URL;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 11/09/2017.
 */
public class WeatherForecastRepositoryTest {

	String mockCityName = "Tartu";
	String mockCountryCode = "EE";
	int mockForecastLengthInDays = 3;
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";

	@Test
	public void testCurrentWeatherRequestURL() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			URL response = repository.getCurrentWeatherRequestURL(request);
			System.out.println(response);
			assertThat(response, instanceOf(URL.class));
		} catch (Exception e){
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testWeatherForecastRequestURL() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			URL response = repository.getWeatherForecastURL(request);
			assertThat(response, instanceOf(URL.class));
			// assertEquals( response, 200, response.getStatus());
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void doesGetCurrentTemperatureReturnsTemperature() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getCurrentTemperature(request);
			assertEquals(true, response.has("temp"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetHighestTemperatureForLastThreeDaysReturnForecastOfThreeDays() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			JSONObject response = repository.getHighestTemperatureForLastThreeDays(request);
			assertEquals(response, instanceOf(JSONObject.class));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void getReturnLowestTemperatureForLastThreeDaysDoesReturnForecastOfThreeDays() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getLowestTemperatureForLastThreeDays(request);
			JSONObject response = repository.getHighestTemperatureForLastThreeDays(request);
			assertEquals(response, instanceOf(JSONObject.class));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getCityCoordinates(request);
			JSONObject response = repository.getHighestTemperatureForLastThreeDays(request);
			assertEquals(response, instanceOf(JSONObject.class));
			assertEquals(true, response.has("coord"));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

}
