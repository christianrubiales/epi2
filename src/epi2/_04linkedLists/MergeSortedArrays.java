package epi2._04linkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// TODO: Merge while minimizing queue size
public class MergeSortedArrays {
	
	static List<Integer> merge(List<List<Integer>> lists) {
		List<Integer> merged = new ArrayList<>();
		
		// sort lists
//		for (List<Integer> list : lists) {
//			Collections.sort(list);
//		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (List<Integer> list : lists) {
			queue.addAll(list);
		}
		
		while (!queue.isEmpty()) {
			merged.add(queue.poll());
		}
		
		return merged;
	}

	public static void main(String[] args) {
		System.out.println(merge(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(1, 2, 3),
			Arrays.asList(1, 2, 3))));
		System.out.println(merge(Arrays.asList(
			Arrays.asList(3,3,3,3,3,3,3,3,3,3,3,3,3),
			Arrays.asList(2,2,2,2,2,2,2,2,2,2,2,2,2),
			Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1))));
	}

}
