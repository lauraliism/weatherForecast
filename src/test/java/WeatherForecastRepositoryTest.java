import org.json.JSONObject;
import org.junit.Test;
import org.openweathermap.api.models.request.WeatherRequest;
import org.openweathermap.api.repository.WeatherForecastRepository;
import org.openweathermap.api.utility.constants.Constants;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 11/09/2017.
 */
public class WeatherForecastRepositoryTest {
	String mockCityName = "London";
	String apiKey = "db1fb1d0d306a8dedfc165d671dd5e4d";
	Constants.UNIT units = Constants.UNIT.metric;

	@Test
	public void doesGetCurrentTemperatureReturnTemperature() {
		try {
			WeatherRequest request = new WeatherRequest(mockCityName, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			assertEquals(repository.getCurrentTemperature(request).getClass(), Double.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetThreeDaysHighestAndLowestTempReturnHashMap() {
		try {
			WeatherRequest request = new WeatherRequest(mockCityName, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			assertEquals(repository.getThreeDaysHighestAndLowestTemp(request).getClass(), HashMap.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() {
		try {
			WeatherRequest request = new WeatherRequest(mockCityName, apiKey, units);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			assertEquals(repository.getCityCoordinates(request).getClass(), JSONObject.class);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void testIfResponseWrittenToFileIsRequestedWithCorrectAppId() {
		try {
			WeatherForecastRepository repository = new WeatherForecastRepository();
			final String APPID = repository.APPID;
			assertEquals(apiKey, APPID);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

}
