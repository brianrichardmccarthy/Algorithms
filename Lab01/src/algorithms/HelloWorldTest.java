package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	/**
	 * Test the HelloWorld.java
	 */
	@Test
	public void test() {
		
		// create an instance of Hello World
		HelloWorldInterface hw = new HelloWorld();
		
		// checks instance is not null
		assertTrue(hw != null);
		
		// print the "Hello World" message to the console
		hw.display();
	}

}
