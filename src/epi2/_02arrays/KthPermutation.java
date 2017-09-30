package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KthPermutation {
	
	static Object[] kthPermutation(Object[] A, int k) {
		List<Integer> fact = factoradic(k);
		
		// copy array to list
		List<Object> list = new LinkedList<>();
		for (Object o : A) {
			list.add(o);
		}
		
		Object[] perm = new Object[A.length];
		for (int i = 0; i < fact.size(); i++) {
			perm[i] = list.remove((int) fact.get(i));
		}
		for (int i = 0; i < list.size(); i++) {
			perm[A.length - list.size() + i] = list.get(i);
		}
		
		return perm;
	}
	
	static List<Integer> factoradic(int k) {
		List<Integer> f = new ArrayList<>();
		
		int i = 1;
		while (k != 0) {
			f.add(0, k % i);
			k /= i;
			i++;
		}
		
		return f;
	}

	public static void main(String[] args) {
//		for (int i = 1; i < 10; i++) {
//			System.out.println(factoradic(i));
//		}
//		System.out.println(factoradic(349));
		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, 0))); // 3,2,1,4
		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, 14))); // 3,2,1,4
		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {0,1,2,3,4,5,6,7,8,9}, 1000000-1))); //2,7,8,3,9,1,5,4,6,0
	}

}
