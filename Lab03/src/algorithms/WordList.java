package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordList implements StringSearchInterface {

	private List<String> wordList;

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

	public void printAll() {
		for (String word : wordList)
			System.out.println(word);
	}

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

	public void addString(String s) {
		wordList.add(s);
	}
	
	public static void main(String[] args) {
		try {
			new WordList("https://dl.dropbox.com/u/18678304/2011/BSc2/words.txt").printAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
