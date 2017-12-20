import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.openweathermap.api.console.FileController;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class FileControllerTest {
	String resourcesDirectory = "/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/";
	String mockCity = "New York";

	@Test
	public void testGetCityNamesFromFileReturnsArrayOfStrings() {
		try {
			FileController fileController = new FileController();
			assertEquals(fileController.getCityNamesFromFile().getClass(), ArrayList.class);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testGetCityNamesFromFileHasCorrectFile() {
		try {
			FileController fileController = new FileController();
			final String file = fileController.INPUT_FILE;
			String fileName = "input.txt";
			assertEquals(resourcesDirectory + fileName, file);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testWriteResultsToFileHasCorrectDirectory() {
		try {
			FileController fileController = new FileController();
			final String directory = fileController.DIRECTORY;
			assertEquals(resourcesDirectory, directory);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testWriteResultsToFileThrowsCorrectException() throws IOException {
		String currentTemperature = "8";
		ArrayList<String> data = new ArrayList<>();
		String threeDayForecast = "{2017-12-22=[2.08, -0.23], 2017-12-24=[4.28, 1.18], 2017-12-23=[4.47, -0.71]}";
		String coordinates = "{\"lon\":24.75,\"lat\":59.44}";
		data.add(threeDayForecast);
		data.add(coordinates);

		FileController fileController = mock(FileController.class);
		Mockito.doThrow(new IOException()).when(fileController).writeResultsToFile(mockCity, currentTemperature, data);

		exception.expect(IOException.class);
		fileController.writeResultsToFile(mockCity, currentTemperature, data);
	}

	@Test
	public void testGetCityNamesFromFileReturnsArrayListOf() throws IOException {
		ArrayList<String> cityNames = new ArrayList<>();
		cityNames.add(mockCity);

		FileController fileController = mock(FileController.class);
		Mockito.when(fileController.getCityNamesFromFile()).thenReturn(cityNames);

		assertThat(fileController.getCityNamesFromFile(), instanceOf(ArrayList.class));
		assertEquals(fileController.getCityNamesFromFile(), cityNames);
		assertEquals(fileController.getCityNamesFromFile().size(), cityNames.size());
		assertEquals(fileController.getCityNamesFromFile().get(0), cityNames.get(0));
	}
}
