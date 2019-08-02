package epi2._07heaps;

import java.util.PriorityQueue;

public class QueueUsingHeap<T> {
	
	static class Entry<T> implements Comparable<Entry<T>>{
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
	PriorityQueue<Entry<T>> heap = new PriorityQueue<>();
	
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
		QueueUsingHeap<Integer> queue = new QueueUsingHeap<>();
		queue.push(1);
		System.out.println(queue.peek());// 1
		queue.push(2);
		System.out.println(queue.peek());// 1
		queue.push(3);
		System.out.println(queue.peek());// 1
		
		System.out.println(queue.pop());// 1
		System.out.println(queue.peek());// 2
		System.out.println(queue.pop());// 2
		System.out.println(queue.peek());// 3
		System.out.println(queue.pop());// 3
	}

}
