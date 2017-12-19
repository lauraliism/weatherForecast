import org.junit.Test;
import org.openweathermap.api.console.FileController;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class FileControllerTest {
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
			assertEquals("/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/"+ fileName, file);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testWriteResultsToFileHasCorrectDirectory() {
		try {
			FileController fileController = new FileController();
			final String directory = fileController.DIRECTORY;
			assertEquals("/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/", directory);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}
