package algorithms;

public class HelloWorld implements HelloWorldInterface {

	private String hello;

	/**
	 * Constructor - Assigns "Hello World" to String instance variable.
	 */
	public HelloWorld() {
		hello = "Hello World!";
	}

	/**
	 * Prints the String instance variable to the console.
	 */
	public void display() {
		System.out.println(hello);
	}

}
