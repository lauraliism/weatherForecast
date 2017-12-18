package org.openweathermap.api.console;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class FileController {
	public final String INPUT_FILE = "/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/input.txt";
	public final String DIRECTORY = "/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/";
	private final String FILE_EXTENSION = ".text";

	public ArrayList<String> getCityNamesFromFile() throws IOException {
		FileReader fr = new FileReader(INPUT_FILE);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		br.close();
		System.out.println("LINES!!!" + lines);
		return lines;
	}

	public void writeResultsToFile(String city, String currentTemperature, ArrayList<String> data) throws IOException {
		FileWriter fw = new FileWriter(new File(DIRECTORY + city + FILE_EXTENSION));
		fw.write(city.toUpperCase() + ": " + '\n' + '\t' + "Max and min temperature for next 3 days & coordinates: " + '\n' + '\t');
		for (String cityData : data) {
			fw.write(cityData + '\n' + '\t');
		}
		fw.close();
	}
}

