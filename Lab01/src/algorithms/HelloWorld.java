package algorithms;

public class HelloWorld implements HelloWorldInterface {

	private String hello;

	public HelloWorld() {
		hello = "Hello World!";
	}

	public void display() {
		System.out.println(hello);
	}

}
