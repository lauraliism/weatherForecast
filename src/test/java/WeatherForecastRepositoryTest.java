import org.junit.Test;
import org.openweathermap.api.repository.WeatherForecastRepository;
import org.openweathermap.api.request.WeatherRequestCurrent;
import org.openweathermap.api.request.WeatherRequestForecast;
import org.openweathermap.exception.NoWeatherReportException;

import java.net.URL;

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
	public void testCurrentWeatherRequestURL() throws NoWeatherReportException {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			URL response = repository.getCurrentWeatherRequestURL(request);
			System.out.println(response);
		} catch (Exception e){
			fail("Failure was caused by: "+ e.getMessage());
		}

	}

	@Test
	public void doesGetCurrentTemperatureReturnTemperature() throws NoWeatherReportException {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getCurrentTemperature(request);

		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetHighestTemperatureForLastThreeDaysReturnForecastOfThreeDays() throws NoWeatherReportException {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getHighestTemperatureForLastThreeDays(request);
		} catch (Exception e) {

		}
	}

	@Test
	public void getReturnLowestTemperatureForLastThreeDaysDoesReturnForecastOfThreeDays() throws NoWeatherReportException {
		try {
			WeatherRequestForecast request = new WeatherRequestForecast(mockCityName, mockCountryCode, mockForecastLengthInDays, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getLowestTemperatureForLastThreeDays(request);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() throws NoWeatherReportException {
		try {
			WeatherRequestCurrent request = new WeatherRequestCurrent(mockCityName, mockCountryCode, apiKey);
			WeatherForecastRepository repository = new WeatherForecastRepository();
			repository.getCityCoordinates(request);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

}
