package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test() {
		HelloWorldInterface hw = new HelloWorld();
		assertTrue(hw != null);
		hw.display();
	}

}
