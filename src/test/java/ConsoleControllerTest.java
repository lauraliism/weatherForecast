import org.junit.Test;
import org.mockito.Mockito;
import org.openweathermap.api.console.ConsoleController;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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
	public void testGetUsersChoiceAskCorrectQuestion() {
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
			Integer usersChoice = 1;

			ConsoleController consoleController = mock(ConsoleController.class);
			Mockito.when(consoleController.getUsersChoice()).thenReturn(usersChoice);

			assertThat(consoleController.getUsersChoice(), instanceOf(Integer.class));
			assertEquals(consoleController.getUsersChoice(), usersChoice);
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}

	@Test
	public void doesGetCityNamesReturnArrayListOfStrings() {
		try {
			ArrayList<String> cityNames = new ArrayList<>();
			cityNames.add("Tokyo");
			cityNames.add("London");

			ConsoleController consoleController = mock(ConsoleController.class);
			Mockito.when(consoleController.getCityNames()).thenReturn(cityNames);

			assertThat(consoleController.getCityNames(), instanceOf(ArrayList.class));
			assertEquals(consoleController.getCityNames(), cityNames);
			assertEquals(consoleController.getCityNames().size(), cityNames.size());
			assertEquals(consoleController.getCityNames().get(0), cityNames.get(0));
			assertEquals(consoleController.getCityNames().get(1), cityNames.get(1));
		} catch (Exception e) {
			fail("Failure was caused by: "+ e.getMessage());
		}
	}
}
