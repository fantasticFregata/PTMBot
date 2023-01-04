package me.fantasticFregata;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVReadAndWrite {

	public static void readDataLineByLine() {

		try {
			// Retrieves filepath
			URL filePath = CSVReadAndWrite.class.getResource("players.csv");
			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(filePath.getFile());

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			// temp var that stores values of each line
			String[] nextRecord;

			// skips header
			csvReader.readNext();
			// as long as the line isn't null
			while ((nextRecord = csvReader.readNext()) != null) {
				// creates new Player and adds them to the arraylist
				BotCommands.players.add(new Player(nextRecord));
			}

			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeDataLineByLine() {

		URL filePath = CSVReadAndWrite.class.getResource("players.csv");

		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath.getFile());
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = { "tag", "region", "position", "pr", "mvps", "char1", "char2", "etc" };
			writer.writeNext(header);

			// add data to csv
			for (Player p : BotCommands.players) {
				writer.writeNext(p.toStringArray());
			}

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}