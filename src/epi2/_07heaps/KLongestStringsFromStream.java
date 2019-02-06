package epi2._07heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KLongestStringsFromStream {
	
	static List<String> longestStrings(Iterator<String> iter, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			}
		});
		
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
		
		List<String> longest = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			longest.add(minHeap.poll());
		}
		
		return longest;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String s = "";
		for (int i = 1; i < 10; i++) {
			s += i;
			list.add(s);
		}
//		System.out.println(list);
		System.out.println(longestStrings(list.iterator(), 2));
//		System.out.println(Arrays.asList("aa","aa","b"));
		System.out.println(longestStrings(Arrays.asList("aa","b","aaa", "cc").iterator(), 2));
		System.out.println(longestStrings(Arrays.asList("aaa","bbb","aa", "cc").iterator(), 2));
	}

}
