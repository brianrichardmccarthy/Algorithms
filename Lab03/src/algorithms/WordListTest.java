package algorithms;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class WordListTest {

	private static final String url = "https://dl.dropbox.com/u/18678304/2011/BSc2/words.txt";

	@Test
	public void testAddString() throws Exception {
		StringSearchInterface wordList;
		String s = "I Love Javaaaaaa!";
		String searchString = "love";

		wordList = new WordList(url);

		wordList.addString(s);
		System.out.println(wordList.getSubstringList(searchString).size());
		// check that the search returned some results
		assertTrue(wordList.getSubstringList(s).size() == 1);

	}

	@Test
	public void testGetSubstringList() throws Exception {
		StringSearchInterface wordList;
		String s = "umb";

		wordList = new WordList(url);
		List<String> resultList = wordList.getSubstringList(s);

		// check that the search returned some result(i.e. there is a match
		// in the list)
		assertTrue(resultList.size() > 0);

	}

	@Test
	public void testWordList() throws Exception {
		StringSearchInterface wordList;

		wordList = new WordList(url);
		assertNotNull(wordList);
	}
}
