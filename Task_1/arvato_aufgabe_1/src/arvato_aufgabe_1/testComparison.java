package arvato_aufgabe_1;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class testComparison {

	@Test
	public void testCompareFiles() {
		
		JSONObject actual = new JSONObject();
		FileComp compFiles = new FileComp();
		actual = compFiles.compareFiles("ExampleData/List1.txt", "ExampleData/List2.txt");
		
		JSONObject expected = new JSONObject();
		try {
			expected.append("inBothLists", "word5");
			expected.append("inBothLists", "word6");
			expected.append("onlyInList2", "word3");
			expected.append("onlyInList2", "word4");
			expected.append("onlyInList1", "word1");
			expected.append("onlyInList1", "word2");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		assertEquals(expected.toString(), actual.toString());
	}

}
