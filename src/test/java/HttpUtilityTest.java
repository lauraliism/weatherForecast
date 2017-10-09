import org.junit.Test;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.utility.HttpUtility;

import java.net.URL;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 09/10/2017.
 */
public class HttpUtilityTest {
	String mockCityName = "Tartu";
	String mockCountryCode = "EE";
	int mockForecastLengthInDays = 3;
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";

	@Test
	public void testCurrentWeatherRequestReturnsURL() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			HttpUtility utility = new HttpUtility();
			URL response = utility.getCurrentWeatherRequestURL(request);
			System.out.println(response);
			assertThat(response, instanceOf(URL.class));
		} catch (Exception e){
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testWeatherForecastRequestReturnURL() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			HttpUtility utility = new HttpUtility();
			URL response = utility.getWeatherForecastURL(request);
			assertThat(response, instanceOf(URL.class));
			// assertEquals( response, 200, response.getStatus());
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testmakeApiRequestReturnString() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			HttpUtility utility = new HttpUtility();
			URL requestURL = utility.getWeatherForecastURL(request);
			String response = utility.makeApiRequest(requestURL.toString());
			assertThat(response, instanceOf(String.class));
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}