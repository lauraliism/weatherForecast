package org.openweathermap.api.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleController {
	public String cityQuestion = "Enter city name: ";
	public String inputQuestion = "How would you like to choose the city?" + '\n' + '\t' + "1) Insert city from console " + '\n' + '\t' + "2) Read cities from \"input.txt\" file ";

	public String chooseCityFromConsole() {
		System.out.println(cityQuestion);
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		return city;
	}

	public Integer getUsersChoice() {
		System.out.println(inputQuestion);
		Scanner scanner = new Scanner(System.in);
		Integer usersChoice = scanner.nextInt();
		return usersChoice;
	}

	public ArrayList<String> getCityNames() throws IOException{
		FileController fileController = new FileController();
		ArrayList<String> cityNameArray = new ArrayList<String>();
		Integer usersChoice = this.getUsersChoice();

		if (usersChoice == 1) {
			String cityName = this.chooseCityFromConsole();
			cityNameArray.add(cityName);
		} else if (usersChoice == 2) {
			cityNameArray = fileController.getCityNamesFromFile();
		}
		return cityNameArray;
	}
}
