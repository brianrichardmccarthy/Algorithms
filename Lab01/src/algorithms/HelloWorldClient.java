package algorithms;

public class HelloWorldClient {

	public static void main(String[] args) {
		
		// create an instance of Hello World
		HelloWorldInterface hw = new HelloWorld();
		
		// print the "Hello World" message to the console
		hw.display();
	}

}
