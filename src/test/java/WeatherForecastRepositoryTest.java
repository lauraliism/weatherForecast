import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openweathermap.api.models.request.WeatherRequest;
import org.openweathermap.api.repository.WeatherForecastRepository;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.api.utility.constants.Constants;
import org.openweathermap.exception.NoWeatherReportException;

import java.io.IOException;
import java.util.HashMap;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by lauraliismetsvaht on 11/09/2017.
 */
public class WeatherForecastRepositoryTest {
	String mockCityName = "London";
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";
	Constants.UNIT units = Constants.UNIT.metric;
	WeatherRequest request;
	WeatherForecastRepository repository;

	String currentWeatherResponse = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50n\"}],\"base\":\"stations\",\"main\":{\"temp\":10,\"pressure\":1035,\"humidity\":100,\"temp_min\":10,\"temp_max\":10},\"visibility\":1800,\"wind\":{\"speed\":2.6,\"deg\":260},\"clouds\":{\"all\":75},\"dt\":1513804800,\"sys\":{\"type\":1,\"id\":5088,\"message\":0.0051,\"country\":\"GB\",\"sunrise\":1513757029,\"sunset\":1513785210},\"id\":2643741,\"name\":\"London\",\"cod\":200}";
	final String currentWeatherRequestUrl = "https://api.openweathermap.org/%2Fdata%2F2.5%2Fweather?q=Tallinn&units=metric&appid=db1fb1d0d306a8dedfc165d671dd5e4d";


	@Before public void init() {
		request = new WeatherRequest(mockCityName, apiKey, units);
		repository = new WeatherForecastRepository();
	}

	@Test
	public void doesGetCurrentTemperatureReturnTemperature() {
		try {
			assertEquals(repository.getCurrentTemperature(request).getClass(), Double.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetThreeDaysHighestAndLowestTempReturnHashMap() {
		try {
			assertEquals(repository.getThreeDaysHighestAndLowestTemp(request).getClass(), HashMap.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() {
		try {
			assertEquals(repository.getCityCoordinates(request).getClass(), JSONObject.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testIfResponseWrittenToFileIsRequestedWithCorrectAppId() {
		try {
			final String APPID = repository.APPID;
			assertEquals(apiKey, APPID);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testIfGetCityCoordinates2ReturnsCorrectResponse() throws IOException, NoWeatherReportException, JSONException {
		String coordinates = "{\"lon\":-0.13,\"lat\":51.51}";
		JSONObject jsonObj = new JSONObject(coordinates);
		System.out.println("jsonObj" + jsonObj);

		HttpUtility utility = mock(HttpUtility.class);
		Mockito.when(utility.makeApiRequest(currentWeatherRequestUrl)).thenReturn(currentWeatherResponse);

		assertEquals(repository.getCityCoordinates2(currentWeatherRequestUrl, utility).toString(), jsonObj.toString());
	}

	@Test
	public void testIfGetCityCoordinates2CallsCorrectAction() throws NoWeatherReportException, JSONException, IOException {
		HttpUtility utility = mock(HttpUtility.class);
		Mockito.when(utility.makeApiRequest(currentWeatherRequestUrl)).thenReturn(currentWeatherResponse);
		repository.getCityCoordinates2(currentWeatherRequestUrl, utility);

		verify(utility, times(1)).makeApiRequest(currentWeatherRequestUrl);
	}

}
