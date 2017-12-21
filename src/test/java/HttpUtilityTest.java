import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openweathermap.api.models.request.WeatherRequest;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.api.utility.constants.Constants;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class HttpUtilityTest {
	String mockCityName = "Tartu";
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";
	Constants.UNIT units = Constants.UNIT.metric;

	String currentWeatherResponse = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50n\"}],\"base\":\"stations\",\"main\":{\"temp\":10,\"pressure\":1035,\"humidity\":100,\"temp_min\":10,\"temp_max\":10},\"visibility\":1800,\"wind\":{\"speed\":2.6,\"deg\":260},\"clouds\":{\"all\":75},\"dt\":1513804800,\"sys\":{\"type\":1,\"id\":5088,\"message\":0.0051,\"country\":\"GB\",\"sunrise\":1513757029,\"sunset\":1513785210},\"id\":2643741,\"name\":\"London\",\"cod\":200}";
	final String currentWeatherRequestUrl = "https://api.openweathermap.org/%2Fdata%2F2.5%2Fweather?q=Tallinn&units=metric&appid=db1fb1d0d306a8dedfc165d671dd5e4d";

	WeatherRequest request;

	@Before
	public void init() {
		System.out.println("before all");
		request = new WeatherRequest(mockCityName, apiKey, units);
	}

	@Test
	public void testCurrentWeatherRequestReturnsString() {
		try {
			HttpUtility utility = new HttpUtility();
			String response = utility.getCurrentWeatherRequestURL(request);
			assertThat(response, instanceOf(String.class));
		} catch (Exception e){
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testWeatherForecastRequestReturnURL() {
		try {
			HttpUtility utility = new HttpUtility();
			String response = utility.getWeatherForecastURL(request);
			assertThat(response, instanceOf(String.class));
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testMakeApiRequestReturnString() {
		try {
			HttpUtility utility = new HttpUtility();
			String requestURL = utility.getWeatherForecastURL(request);
			String response = utility.makeApiRequest(requestURL);
			assertThat(response, instanceOf(String.class));
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testMakeApiRequestReturnsCorrectResponse() {
		try {
			HttpUtility utility = mock(HttpUtility.class);

			Mockito.when(utility.getCurrentWeatherRequestURL(request)).thenReturn(currentWeatherRequestUrl);
			Mockito.when(utility.makeApiRequest(currentWeatherRequestUrl)).thenReturn(currentWeatherResponse);

			assertThat(utility.getCurrentWeatherRequestURL(request), instanceOf(String.class));


			assertEquals(utility.makeApiRequest(currentWeatherRequestUrl), currentWeatherResponse);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}
