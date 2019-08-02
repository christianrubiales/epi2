package epi2._07heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfOnlineData {
	
	static List<Double> getRunningMedians(Iterator<Integer> stream) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		List<Double> medians = new ArrayList<>();
		
		while (stream.hasNext()) {
			Integer next = stream.next();
			// if first element
			if (minHeap.isEmpty()) {
				minHeap.offer(next);
			} else {
				// if number should be in larger half
				if (next >= minHeap.peek()) {
					minHeap.offer(next);
				} else {
					maxHeap.offer(next);
				}
			}
			
			if (minHeap.size() == maxHeap.size() + 2) {
				maxHeap.offer(minHeap.poll());
			} else if (maxHeap.size() > minHeap.size()) {
				minHeap.offer(maxHeap.poll());
			}
			
			if (minHeap.size() == maxHeap.size()) {
				medians.add(((double) minHeap.peek() + maxHeap.peek()) / 2);
			} else {
				medians.add((double) minHeap.peek());
			}
		}
		
		return medians;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,0,3,5,2,0,1);
		System.out.println(getRunningMedians(list.iterator()));//1,0.5,1,2,2,1.5,1
	}

}
