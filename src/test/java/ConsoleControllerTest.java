import org.junit.Test;
import org.openweathermap.api.console.ConsoleController;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleControllerTest {

	@Test
	public void testChooseCityFromConsoleAskCorrectQuestion() {
		try {
			ConsoleController consoleController = new ConsoleController();
			String cityQuestion = consoleController.cityQuestion;
			assertEquals("Enter city name: ", cityQuestion);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void testgetUsersChoiceAskCorrectQuestion() {
		try {
			ConsoleController consoleController = new ConsoleController();
			String inputQuestion = consoleController.inputQuestion;
			String question = "How would you like to choose the city?" + '\n' + '\t' + "1) Insert city from console " + '\n' + '\t' + "2) Insert city from file ";
			assertEquals(question, inputQuestion);
		} catch (Exception e) {
			fail("Failure was caused by: " + e.getMessage());
		}
	}

	@Test
	public void doesGetUsersChoiceReturnInteger() {
		try {
			ConsoleController consoleController = new ConsoleController();
			Integer usersChoice = consoleController.getUsersChoice();
			assertEquals(usersChoice, instanceOf(Integer.class));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}
}
