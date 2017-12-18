import org.junit.Test;
import org.openweathermap.api.console.FileController;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class FileControllerTest {
	@Test
	public void testGetCityNameFromFileReturnsArrayOfStrings() {
		try {
			org.openweathermap.api.console.FileController fileController = new org.openweathermap.api.console.FileController();
			ArrayList <String> cityNames = org.openweathermap.api.console.FileController.getCityNameFromFile();
			assertEquals(cityNames, instanceOf(ArrayList.class));
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}
