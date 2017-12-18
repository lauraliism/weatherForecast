package org.openweathermap.api.console;

import java.util.Scanner;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleController {
	public String cityQuestion = "Enter city name: ";
	public String inputQuestion = "How would you like to choose the city?" + '\n' + '\t' + "1) Insert city from console " + '\n' + '\t' + "2) Insert city from file ";

	public String chooseCityFromConsole () {
		System.out.println(cityQuestion);
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		System.out.println("Your city is " + city);
		return city;
	}

	public Integer getUsersChoice () {
		System.out.println(inputQuestion);
		Scanner scanner = new Scanner(System.in);
		Integer usersChoice = scanner.nextInt();
		System.out.println("Your Choice is " + usersChoice);
		return usersChoice;
	}
}
