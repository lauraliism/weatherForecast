import org.junit.Test;
import org.openweathermap.api.console.ConsoleController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleControllerTest {

	@Test
	public void testChooseCityFromConsoleAsksCorrectQuestion() {
		try {
			ConsoleController consoleController = new ConsoleController();
			String question = consoleController.cityQuestion;
			assertEquals("Enter city name: ", question);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}
}
