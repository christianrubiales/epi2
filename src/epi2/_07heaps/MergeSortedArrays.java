package epi2._07heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {
	
	static class HeapEntry {
		Integer value;
		Integer arrayId;
		
		HeapEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}
	
	static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
		
		// populate iterators
		List<Iterator<Integer>> iters = new ArrayList<>();
		for (List<Integer> list : lists) {
			iters.add(list.iterator());
		}
		
		// initially populate min heap
		PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(
			new Comparator<HeapEntry>() {
				@Override
				public int compare(HeapEntry o1, HeapEntry o2) {
					return o1.value.compareTo(o2.value);
				};
			}
		);
		for (int i = 0; i < iters.size(); i++) {
			minHeap.offer(new HeapEntry(iters.get(i).next(), i));
		}

		// continuously poll and offer
		List<Integer> merged = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			HeapEntry entry = minHeap.poll();
			merged.add(entry.value);
			Iterator<Integer> iter = iters.get(entry.arrayId);
			if (iter.hasNext()) {
				minHeap.add(new HeapEntry(iter.next(), entry.arrayId));
			}
		}
		
		return merged;
	}

	public static void main(String[] args) {
		System.out.println(mergeSortedLists(Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3))));
			System.out.println(mergeSortedLists(Arrays.asList(
				Arrays.asList(3,3,3,3,3,3,3,3,3,3,3,3,3),
				Arrays.asList(2,2,2,2,2,2,2,2,2,2,2,2,2),
				Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1))));
	}

}
