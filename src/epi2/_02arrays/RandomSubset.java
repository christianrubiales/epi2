package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomSubset {
	
	// return a random array of indices to apply to the original array to get the subset
	// mimicking swapping values in Fisher-Yates but does not need full O(n) space
	// O(k) time, O(k) space
	static Set<Integer> randomSubset(int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		Random random = new Random();
		
		for (int i = 0; i < k; ++i) {
			int r = i + random.nextInt(n - i);

			Integer vr = map.get(r);
			Integer vi = map.get(i);

			if (vr == null && vi == null) {
				map.put(r, i);
				map.put(i, r);
			} else if (vr == null && vi != null) {
				map.put(r, vi);
				map.put(i, r);
			} else if (vr != null && vi == null) {
				map.put(i, vr);
				map.put(r, i);
			} else {
				map.put(i, vr);
				map.put(r, vi);
			}
		}

//		Set<Integer> subset = new TreeSet<>();
		Set<Integer> subset = new HashSet<>();
		for (int i = 0; i < k; i++) {
			subset.add(map.get(i));
		}
		
		return subset;
	}
	
	// DOES NOT WORK
	static Set<Integer> randomSubset2(int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		Random random = new Random();
		
		for (int i = 0; i < k; ++i) {
			int r = i + random.nextInt(n - i);

			Integer vr = map.get(r);
			Integer vi = map.get(i);

			if (vr == null) {
				map.put(r, i);
				map.put(i, r);
			} else {
				map.put(i, vr);
				map.put(i, r);
				map.put(r, i);
				map.put(r, vi);
			}
		}

//		Set<Integer> subset = new TreeSet<>();
		Set<Integer> subset = new HashSet<>();
		for (int i = 0; i < k; i++) {
			subset.add(map.get(i));
		}
		
		return subset;
	}
	
	// DOES NOT WORK
	static Set<Integer> randomSubset3(int n, int k) {
		Set<Integer> subset = new TreeSet<>();
		Random random = new Random();
		
		for (int i = 0; i < k; ++i) {
			int r = i + random.nextInt(n - i);
			
			if (!subset.contains(r)) {
				subset.add(r);
			} else {
				subset.add(i);
			}
		}
		
		return subset;
	}
	
	static List<Integer> randomSubsetEPI(int n, int k) {
		Map<Integer, Integer> changedElements = new HashMap<>();
		Random random = new Random();
		
		for (int i = 0; i < k; ++i) {
			int randIdx = i + random.nextInt(n - i);
			Integer ptr1 = changedElements.get(randIdx);
			Integer ptr2 = changedElements.get(i);

			if (ptr1 == null && ptr2 == null) {
				changedElements.put(randIdx, i);
				changedElements.put(i, randIdx);
			} else if (ptr1 == null && ptr2 != null) {
				changedElements.put(randIdx, ptr2);
				changedElements.put(i, randIdx);
			} else if (ptr1 != null && ptr2 == null) {
				changedElements.put(i, ptr1);
				changedElements.put(randIdx, i);
			} else {
				changedElements.put(i, ptr1);
				changedElements.put(randIdx, ptr2);
			}
		}
		
		List<Integer> subset = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			subset.add(changedElements.get(i));
		}
//		Collections.sort(subset);
		
		return subset;
	}

	public static void main(String[] args) {
		
		System.out.println(randomSubset(1, 1));
		System.out.println(randomSubset(2, 1));
		System.out.println(randomSubset(2, 2));
		System.out.println(randomSubset(3, 1));
		System.out.println(randomSubset(3, 2));
		System.out.println(randomSubset(3, 3));
		System.out.println(randomSubset(20, 5));
		System.out.println(randomSubset(20, 18));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));
		System.out.println(randomSubset(20, 20));

//		System.out.println(randomSubset2(1, 1));
//		System.out.println(randomSubset2(2, 1));
//		System.out.println(randomSubset2(2, 2));
//		System.out.println(randomSubset2(3, 1));
//		System.out.println(randomSubset2(3, 2));
//		System.out.println(randomSubset2(3, 3));
//		System.out.println(randomSubset2(20, 5));
//		System.out.println(randomSubset2(20, 28));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));
//		System.out.println(randomSubset2(20, 20));

//		System.out.println(randomSubsetEPI(1, 1));
//		System.out.println(randomSubsetEPI(2, 1));
//		System.out.println(randomSubsetEPI(2, 2));
//		System.out.println(randomSubsetEPI(3, 1));
//		System.out.println(randomSubsetEPI(3, 2));
//		System.out.println(randomSubsetEPI(3, 3));
//		System.out.println(randomSubsetEPI(20, 28));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
//		System.out.println(randomSubsetEPI(20, 20));
	}

}
