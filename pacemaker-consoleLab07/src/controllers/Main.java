package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;
import utils.FileLogger;

public class Main {
	/*
	 * public static void main(String[] args) throws IOException { FileLogger
	 * logger = FileLogger.getLogger(); logger.log("Creating user list");
	 * 
	 * // Exercise: Convert Array List to linked list. List<User> users = new
	 * LinkedList<User>(); // List<User> users = new ArrayList<User>();
	 * 
	 * users.add(new User("Bart", "Simpson", "bart@simpson.com", "secret"));
	 * users.add(new User("Homer", "Simpson", "bart@simpson.com", "secret"));
	 * users.add(new User("Lisa", "Simpson", "bart@simpson.com", "secret"));
	 * System.out.println(users);
	 * 
	 * logger.log("Serializing contacts to XML"); XStream xstream = new
	 * XStream(new DomDriver()); ObjectOutputStream out =
	 * xstream.createObjectOutputStream(new FileWriter("users.xml"));
	 * out.writeObject(users);
	 * 
	 * // Exercise: Create a users.json file.
	 * logger.log("Serializing contacts to JSON"); XStream xstreamJson = new
	 * XStream(new JsonHierarchicalStreamDriver()); ObjectOutputStream outJson =
	 * xstreamJson.createObjectOutputStream(new FileWriter("users.json"));
	 * outJson.writeObject(users);
	 * 
	 * // close the file writers out.close(); outJson.close();
	 * 
	 * logger.log("Finished - shutting down");
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {
		PacemakerAPI pacemakerAPI = new PacemakerAPI();

		pacemakerAPI.createUser("Bart", "Simpson", "bart@simpson.com", "secret");
		pacemakerAPI.createUser("Homer", "Simpson", "homer@simpson.com", "secret");
		pacemakerAPI.createUser("Lisa", "Simpson", " lisa@simpson.com", "secret");

		Collection<User> users = pacemakerAPI.getUsers();
		// System.out.println(users);

		User homer = pacemakerAPI.getUserByEmail("homer@simpson.com");
		System.out.println(homer);

		pacemakerAPI.deleteUser(homer.id);
		users = pacemakerAPI.getUsers();
		// System.out.println(users);
	}
}