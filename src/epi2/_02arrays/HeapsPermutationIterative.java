package epi2._02arrays;

import java.util.HashSet;
import java.util.Set;

public class HeapsPermutationIterative {
	
	static Set<String> set = new HashSet<>();
	
	static void generate(char[] A) {
//		set.clear();
		int[] c = new int[A.length];
		System.out.println(A);
//		set.add(new String(A));
		
		int i = 0;
		while (i < A.length) {
			if (c[i] < i) {
				if (i % 2 == 0) {
					swap(A, 0, i);
				} else {
					swap(A, c[i], i);
				}
				
				System.out.println(A);
//				set.add(new String(A));
				
				c[i]++;
				i = 0;
			} else {
				c[i] = 0;
				i++;
			}
		}
//		System.out.println(set.size());
	}
	
	static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
//		generate("ABC".toCharArray());
		generate("123".toCharArray());
//		generate("1234".toCharArray());
		generate("ABCD".toCharArray());
//		generate("112".toCharArray());
	}
}
