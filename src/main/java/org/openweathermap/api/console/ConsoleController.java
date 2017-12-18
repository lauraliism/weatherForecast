package org.openweathermap.api.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class ConsoleController {
	public String cityQuestion = "Enter city name: ";
	public String inputQuestion = "How would you like to choose the city?" + '\n' + '\t' + "1) Insert city from console " + '\n' + '\t' + "2) Insert city from file ";

	private String chooseCityFromConsole() {
		System.out.println(cityQuestion);
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		System.out.println("Your city is " + city);
		return city;
	}

	private Integer getUsersChoice() {
		System.out.println(inputQuestion);
		Scanner scanner = new Scanner(System.in);
		Integer usersChoice = scanner.nextInt();
		System.out.println("Your Choice is " + usersChoice);
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
		System.out.println("cityNameArray!!!!!" + cityNameArray);
		return cityNameArray;
	}
}
