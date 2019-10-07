package arvato_aufgabe_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class txtReader {

	/**
	 * This method reads a txt file into a list of strings and returns the list.
	 * @param fileName
	 * @return Content of the file per line in a List<String>
	 */
	public List<String> readFile(String fileName) {
		
		List<String> lines = new ArrayList<String>();
		// this will reference one line at a time, if the file has more than one line
		String line = null;
		
		FileReader fileReader;
		
		try {
			// read txt file 
			fileReader = new FileReader(fileName);

			// wrap FileReader in BufferedReader
			BufferedReader buffReader = new BufferedReader(fileReader);
			
			while ((line = buffReader.readLine()) != null ) {
				lines.add(line);
			}
			
			// Close the file!
			buffReader.close();
			
		// Error handling for reading and opening the file
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file " + fileName + ".");
		} catch (IOException e) {
			System.out.println("Error reading file " + fileName + ".");
			e.printStackTrace();
		}
		
		// return a list with all lines from the file
		return lines;
	}
}
