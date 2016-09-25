package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Brian
 * @version 1.0
 * Program Name: WordList
 * Program Interface: StringSearchInterface
 * Program Description: 
 */
public class WordList implements StringSearchInterface {

	private List<String> wordList;

	/**
	 * Reads in a text file from a web site and stores the word in a array list.<br>Finally sorts the array list. Throws Exception.
	 * @param url web link to the text file.
	 * @throws Exception
	 */
	public WordList(String url) throws Exception {
		BufferedReader in = null;

		try {
			wordList = new ArrayList<String>();
			URL link = new URL(url);
			in = new BufferedReader(new InputStreamReader(link.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				wordList.add(inputLine);
			Collections.sort(wordList);
		} finally {
			if (in != null)
				in.close();
		}
	}

	/**
	 * Prints each word in the array list.
	 */
	public void printAll() {
		for (String word : wordList)
			System.out.println(word);
	}

	/**
	 * @param String subString (to be searched)
	 * @return List (of words containing the specified sub string.
	 */
	public List<String> getSubstringList(String subString) {
		
		List<String> foundWords = new ArrayList<String>();
		for (String word : wordList) {
			if (word.length() < subString.length())
				continue;
			else if (word.indexOf(subString) != -1)
				foundWords.add(word);
		}
		
		return foundWords;
	}

	/**
	 * Checks if the given String is in the array list already.<br>If it is, then the word will not be added.<br>Else the word is add, <br>and resorts the array list.
	 * @param String s (word to be added)
	 */
	public void addString(String s) {
		for (String temp : wordList)
			if (temp.equals(s)) {
				System.out.println(s + " is already in the array list");
				return;
			}
		Collections.sort(wordList);
		wordList.add(s);
	}
	
	
	public static void main(String[] args) {
		try {
			new WordList("https://dl.dropbox.com/u/18678304/2011/BSc2/words.txt").printAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
