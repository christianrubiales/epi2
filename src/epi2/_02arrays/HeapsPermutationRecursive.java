package epi2._02arrays;

import java.util.HashSet;
import java.util.Set;

public class HeapsPermutationRecursive {
	
	static Set<char[]> set = new HashSet<>();
	
	static void generate(char[] A) {
		set.clear();
		char[] c = new char[A.length];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
		
		System.out.println(A);
		set.add(A);
		
		int i = 0;
		while (i < A.length) {
			if (c[i] < i) {
				if (i % 2 == 0) {
					swap(A, 0, i);
				} else {
					swap(A, i, 0);
				}
				System.out.println(A);
				set.add(A);
				c[i]++;
				i = 0;
			} else {
				c[i] = 0;
				i++;
			}
		}
		System.out.println(set.size());
	}
	
	static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		generate("ABC".toCharArray());
		generate("1234".toCharArray());
		generate("ABCD".toCharArray());
	}
}