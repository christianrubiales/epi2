package epi2._00bonus;

import java.util.HashSet;
import java.util.Set;

public class TwoSumSinglePass {
	
	static void twoSum(int[] a, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			if (set.contains(k - i)) {
				System.out.println(i + " + " + (k - i) + " = " + k);
				return;
			} else {
				set.add(i);
			}
		}
	}

	public static void main(String[] args) {
		twoSum(new int[] {10,9,8,7,6,5,4,3,2,1}, 3);
	}

}
