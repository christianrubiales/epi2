package epi2._05stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMaxOptimized {
	
	static class MaxWithCount {
		Integer max;
		Integer count;
		
		MaxWithCount(Integer max, Integer count) {
			this.max = max;
			this.count = count;
		}
	}
	
	Deque<Integer> stack = new ArrayDeque<>();
	Deque<MaxWithCount> maxStack = new ArrayDeque<>();
	
	public void push(Integer x) {
		if (stack.isEmpty()) {
			stack.push(x);
			maxStack.push(new MaxWithCount(x, 1));
		} else {
			stack.push(x);
			if (x == maxStack.peek().max) {
				maxStack.peek().count++;
			} else {
				maxStack.push(new MaxWithCount(x, 1));
			}
		}
	}
	
	public Integer pop() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("stack is empty");
		} else {
			maxStack.peek().count--;
			if (maxStack.peek().count == 0) {
				maxStack.pop();
			}
			
			return stack.pop();
		}
	}
	
	public Integer max() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("stack is empty");
		} else {
			return maxStack.peek().max;
		}
	}

	public static void main(String[] args) {

		StackWithMaxOptimized stack = new StackWithMaxOptimized();
		
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
