package epi2._07heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingHeap<T> {
	
	static class Entry<T> implements Comparable<Entry<T>> {
		T value;
		int index;
		
		Entry(T value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Entry<T> other) {
			return index - other.index;
		}
	}
	
	int counter = 0;
	PriorityQueue<Entry<T>> heap = new PriorityQueue<>(Comparator.reverseOrder());
	
	public void push(T value) {
		heap.offer(new Entry<T>(value, counter++));
	}
	
	public T pop() {
		counter--;
		return heap.poll().value;
	}
	
	public T peek() {
		return heap.peek().value;
	}

	public static void main(String[] args) {
		StackUsingHeap<Integer> stack = new StackUsingHeap<>();
		stack.push(1);
		System.out.println(stack.peek());// 1
		stack.push(2);
		System.out.println(stack.peek());// 2
		stack.push(3);
		System.out.println(stack.peek());// 3
		
		System.out.println(stack.pop());// 3
		System.out.println(stack.peek());// 2
		System.out.println(stack.pop());// 2
		System.out.println(stack.peek());// 1
		System.out.println(stack.pop());// 1
	}

}
