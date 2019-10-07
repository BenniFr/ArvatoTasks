package arvato_aufgabe_1;

import java.util.List;

import arvato_aufgabe_1.txtReader;
import org.json.*;
public class FileComp {
	
	List<String> file1;
	List<String> file2;
	String fileName1;
	String fileName2;
	JSONObject result = new JSONObject();

	public static void main(String[] args) {
		FileComp compFiles = new FileComp();
		// set the path and the name for both files!
		compFiles.fileName1 = "ExampleData/List1.txt";
		compFiles.fileName2 = "ExampleData/List2.txt";
		compFiles.compareFiles(compFiles.fileName1, compFiles.fileName2);
	}
	
	/**
	 * This method compares the two text files and prints the result to the console.
	 * The result is displayed in a JSONObject with following keys: inBothLists, onlyInList1, onlyInList2
	 * @param fN1 path to the first file
	 * @param fN2 path to the second file
	 */
	public void compareFiles(String fN1, String fN2) {
		
		// convert both files to a list of strings
		txtReader tR = new txtReader();
		file1 = tR.readFile(fN1);
		file2 = tR.readFile(fN2);
		
		try {
			// Go through the lists and check if the element is in both lists or only in one
			for(int i = 0; i< file1.size(); i++) {
				// If the element is in both list, append the element with the key "inBothLists" to the result JSON
				if(file2.contains(file1.get(i)) == true) {
					result.append("inBothLists", file1.get(i));
				// If the element is only in the first file, append the element with the key "onlyInList1" to the result JSON
				}else if(file2.contains(file1.get(i)) != true){
					result.append("onlyInList1", file1.get(i));	
				}
				
				// If the element of the second file is only in the second list,
				// append the element with the key "onlyInList2" to the result JSON
				if(file1.contains(file2.get(i)) != true) {
					result.append("onlyInList2", file2.get(i));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// print the result to the console
		System.out.println(result.toString());
	}

}
