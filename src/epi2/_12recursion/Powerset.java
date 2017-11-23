package epi2._12recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// @see http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
public class Powerset {
	
	static List<List<Object>> powerset(List<Object> set) {
		List<List<Object>> power = new LinkedList<>();
		int n = set.size();
		
		for (long i = 0; i < (1L << n); i++) {
			List<Object> list = new LinkedList<>();
			power.add(list);
			
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					list.add(set.get(j));
				}
			}
		}
		
		return power;
	}

	public static void main(String[] args) {
		System.out.println(powerset(Arrays.asList()));
		System.out.println(powerset(Arrays.asList(1)));
		System.out.println(powerset(Arrays.asList(1,2)));
		System.out.println(powerset(Arrays.asList(1,2,3)));
		System.out.println(powerset(Arrays.asList(1,2,3,4)));
		System.out.println(powerset(Arrays.asList(1,2,3,4,5,6,7,8)));
		
		List<Object> set = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			set.add(i);
		}
		List<List<Object>> pow = powerset(set);
		System.out.println(pow.size());
	}

}
