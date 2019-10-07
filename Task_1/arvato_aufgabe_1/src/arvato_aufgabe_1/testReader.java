package arvato_aufgabe_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testReader {

	@Test
	public void testReadFileOne() {
		
		txtReader textReader = new txtReader();
		List<String> file1 = textReader.readFile("ExampleData/List1.txt");
		
		List<String> expectedFile1 = new ArrayList<String>();
		expectedFile1.add("word1");
		expectedFile1.add("word2");
		expectedFile1.add("word5");
		expectedFile1.add("word6");
		
		assertEquals(expectedFile1, file1);
	}
	
	@Test
	public void testReadFileTwo() {
		
		txtReader textReader = new txtReader();
		List<String> file2 = textReader.readFile("ExampleData/List2.txt");
		
		List<String> expectedFile2 = new ArrayList<String>();
		expectedFile2.add("word5");
		expectedFile2.add("word6");
		expectedFile2.add("word3");
		expectedFile2.add("word4");
		
		assertEquals(expectedFile2, file2);
	}

}
