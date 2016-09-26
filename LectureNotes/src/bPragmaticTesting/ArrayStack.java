package bPragmaticTesting;

import java.util.ArrayList;

public class ArrayStack<T> implements Stack {

	private int index;
	private ArrayList<T> stack;
	
	
	
	public ArrayStack() {
		index = 0;
		stack = new ArrayList<T>();
	}

	@Override
	public Object pop() {
		if (index == 0)
			throw new RuntimeException("Empty Stack");
		return stack.get(--index);
	}

	@Override
	public void push(Object s) {
		// stack.add(s)
	}

	@Override
	public Object top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
