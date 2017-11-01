package epi2._05stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax {
	
	private static class Element {
		Integer value;
		Integer max;
		
		Element(Integer value, Integer max) {
			this.value = value;
			this.max = max;
		}
	}
	
	private final Deque<Element> stack = new ArrayDeque<>();
	
	public Integer max() {
		if (this.stack.isEmpty()) {
			throw new IllegalStateException("stack is empty");
		} else {
			return this.stack.peek().max;
		}
	}
	
	public void push(Integer x) {
		int max = this.stack.isEmpty() ? x: Math.max(this.max(), x);
		stack.push(new Element(x, max));
	}
	
	public Integer pop() {
		if (this.stack.isEmpty()) {
			throw new IllegalStateException("stack is empty");
		} else {
			return this.stack.pop().value;
		}
	}
	
	public static void main(String[] args) {
		StackWithMax stack = new StackWithMax();
		
		for (int i = 0; i < 5; i++) {
			stack.push(i);
			System.out.println(stack.max());
		}

		for (int i = 0; i < 5; i++) {
			stack.pop();
			System.out.println(stack.max());
		}
	}
}
