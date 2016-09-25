package utils;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileLogger {
	private static FileLogger logger;

	private FileLogger() {
	}

	/**
	 * Allows the user to use the FileLogger.<br>Only allows for one instance to be created.
	 * @return logger object
	 */
	public static FileLogger getLogger() {
		if (logger == null)
			logger = new FileLogger();
		return logger;
	}

	/**
	 * Create a text file called "log.txt"
	 * @param msg (String -  to be added to log)
	 * @return true if successful, else false if a error is thrown.
	 */
	public boolean log(String msg) {
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileWriter("log.txt", true));
				writer.println(msg);
				writer.close();
				return true;
			} catch (Exception e) {
				return false;
			}
	}
}