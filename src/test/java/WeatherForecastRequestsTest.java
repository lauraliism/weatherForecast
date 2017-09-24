import org.junit.Test;
import org.openweathermap.api.WeatherForecast;

/**
 * Created by lauraliismetsvaht on 11/09/2017.
 */
public class WeatherForecastRequestsTest {

	WeatherForecast weatherForecast = new WeatherForecast();
	String mockCityName = "Tartu";
	String mockCountryCode = "EE";
	Integer mockForecastLengthInDays = 3;

	@Test
	public void testConnectionToWeatherAPI() {
	}

	@Test
	public void doesGetCurrentTemperatureReturnTemperature() {
		weatherForecast.getCurrentTemperature(mockCityName, mockCountryCode);
	}

	@Test
	public void doesGetHighestTemperatureForLastThreeDaysReturnForecastOfThreeDays() {
		weatherForecast.getHighestTemperatureForLastThreeDays(mockCityName, mockCountryCode, mockForecastLengthInDays);
	}

	@Test
	public void getReturnLowestTemperatureForLastThreeDaysDoesReturnForecastOfThreeDays() {
		weatherForecast.getLowestTemperatureForLastThreeDays(mockCityName, mockCountryCode, mockForecastLengthInDays);
	}

	@Test
	public void doesGetCityCoordinatesReturnCoordinates() {
		weatherForecast.getCityCoordinates(mockCityName, mockCountryCode);
	}

}
