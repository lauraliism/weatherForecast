package org.openweathermap.api.console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lauraliismetsvaht on 18/12/2017.
 */
public class FileController {
	public final String INPUT_FILE = "/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/input.txt";
	public final String OUTPUT_FILE = "/Users/lauraliismetsvaht/IdeaProjects/SOULmate1/weatherForecast1/src/main/resources/output.txt";

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

	public void writeResultsToFile() throws IOException {
		
	}
}

