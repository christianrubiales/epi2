package epi2._07heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KLongestStringsFromStream {
	
	static List<String> longestStrings(Iterator<String> iter, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<>();
		
		for (int i = 0; i < k && iter.hasNext(); i++) {
			minHeap.offer(iter.next());
		}
		
		String s;
		while (iter.hasNext()) {
			s = iter.next();
			if (s.length() > minHeap.peek().length()) {
				minHeap.poll();
				minHeap.offer(s);
			}
		}
		
		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String s = "";
		for (int i = 1; i < 10; i++) {
			s += i;
			list.add(s);
		}
		System.out.println(list);
		System.out.println(longestStrings(list.iterator(), 3));
	}

}
