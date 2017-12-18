package org.openweathermap.api.console;

import java.util.Scanner;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleController {
	public String cityQuestion = "Enter city name: ";

	public String chooseCityFromConsole () {
		System.out.println(cityQuestion);
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		System.out.println("Your city is " + city);
		return city;
	}
}
