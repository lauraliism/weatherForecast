import org.junit.Test;
import org.openweathermap.api.models.request.WeatherRequestCurrent;
import org.openweathermap.api.models.request.WeatherRequestForecast;
import org.openweathermap.api.utility.HttpUtility;
import org.openweathermap.api.utility.constants.Constants;

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
	Constants.UNIT units = Constants.UNIT.metric;

	@Test
	public void testCurrentWeatherRequestReturnsString() {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, apiKey, units);
			HttpUtility utility = new HttpUtility();
			String response = utility.getCurrentWeatherRequestURL(request);
			System.out.println(response);
			assertThat(response, instanceOf(String.class));
		} catch (Exception e){
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testWeatherForecastRequestReturnURL() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockForecastLengthInDays, apiKey, units);
			HttpUtility utility = new HttpUtility();
			String response = utility.getWeatherForecastURL(request);
			assertThat(response, instanceOf(String.class));
			// assertEquals( response, 200, response.getStatus()
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testmakeApiRequestReturnString() {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockForecastLengthInDays, apiKey, units);
			HttpUtility utility = new HttpUtility();
			String requestURL = utility.getWeatherForecastURL(request);
			String response = utility.makeApiRequest(requestURL);
			assertThat(response, instanceOf(String.class));
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}
