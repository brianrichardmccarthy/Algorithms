package algorithms;

import java.util.Scanner;

public class BuggyStringReverse {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		String s;

		System.out.println("\n Please enter a String to reverse: ");
		s = stdin.next();

		stdin.close();
		System.out.println("The reverse of \"" + s + "\" is " + reverseString(s));

	}

	public static String reverseString(String s) {

		// initiate vars
		String rev = "";
		int counter = 0;

		for (int i = 0; i < s.length(); i++) 
			rev += s.charAt(s.length() - ++counter);
		
		return rev;
	}
}