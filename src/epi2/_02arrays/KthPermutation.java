package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @see https://oeis.org/A030299/list
 */
public class KthPermutation {
	
	// @see https://github.com/lucaslouca/kth-permutation/blob/master/PermutationSequence.java
	static Object[] kthPermutation(Object[] A, int k) {
		
		// copy array to list
		List<Object> copy = new LinkedList<>();
		for (Object o : A) {
			copy.add(o);
		}

		int n = A.length;
		Object[] perm = new Object[n];
		int fact = factorial(n - 1);
		int i;
		while (n > 0) {
			i = k / fact;
			perm[A.length - n] = copy.get(i);
			copy.remove(i);
			k = k % fact; // Rest
			fact /= Math.max(1, (n - 1)); // (n-1)!, (n-2)!, (n-3)!, ... 
			n--;
		}

		return perm;
	}
	
	static int factorial(int n) {
		int result = 1;
		
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	// not much difference with LinkedList
	static Object[] kthPermutation1(Object[] A, int k) {
		List<Integer> fact = factoradic(k);
		
		// copy array to list
		List<Object> list = new LinkedList<>();
		for (Object o : A) {
			list.add(o);
		}

		// get the values pointed to by the factoradic indexes
		Object[] perm = new Object[A.length];
		for (int i = 0; i < fact.size(); i++) {
			perm[i] = list.remove((int) fact.get(i));
		}
		
		// get the remaining unused values
		for (int i = 0; i < list.size(); i++) {
			perm[A.length - list.size() + i] = list.get(i);
		}
		
		return perm;
	}
	
	// not much difference with LinkedList
	static Object[] kthPermutation2(Object[] A, int k) {
		List<Integer> fact = factoradic(k);
		
		// copy array to list
		List<Object> list = new ArrayList<>();
		for (Object o : A) {
			list.add(o);
		}

		// get the values pointed to by the factoradic indexes
		Object[] perm = new Object[A.length];
		for (int i = 0; i < fact.size(); i++) {
			perm[i] = list.remove((int) fact.get(i));
		}
		
		// get the remaining unused values
		for (int i = 0; i < list.size(); i++) {
			perm[A.length - list.size() + i] = list.get(i);
		}
		
		return perm;
	}
	
	// bitset with bit manipulation is very complicated and is just a bit faster
	static Object[] kthPermutation3(Object[] A, int k) {
		List<Integer> fact = factoradic(k);
		
		Object[] perm = new Object[A.length];
		long bitset = -1L >>> 64 - A.length; // all set initially
		int numset = 0;
		for (int i = 0; i < fact.size(); i++) {
			long x = bitset;
			int t = fact.get(i);
			long j = 0;
			
			// get the correct set index
			while (t > -1) {
				j = x & ~(x-1);
				x &= x-1;
				t--;
			}
			bitset &= ~j;
			
			// translate set bit to array index
			int b = 0;
			while (j > 1) {
				b++;
				j >>>= 1;
			}
			perm[i] = A[b];
			numset++;
		}
		
		// get the remaining unused values
		while (numset < A.length) {
			long j = bitset & ~(bitset-1);
			bitset &= ~j;
			int b = 0;
			while (j > 1) {
				b++;
				j >>>= 1;
			}
			perm[numset] = A[b];
			numset++;
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
//		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, 0))); // 1,2,3,4
//		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, 1))); // 1,2,4,3
		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, 14))); // 3,2,1,4
//		System.out.println(Arrays.deepToString(kthPermutation(new Object[] {0,1,2,3,4,5,6,7,8,9}, 1000000-1))); //2,7,8,3,9,1,5,4,6,0
		
//		for (int i = 0; i < 24; i++) {
//			System.out.println(Arrays.deepToString(kthPermutation(new Object[] {1,2,3,4}, i)));
//		}
//		for (int i = 0; i < 24; i++) {
//			System.out.println(Arrays.deepToString(kthPermutation(new Object[] {'a','b','c','d'}, i)));
//		}
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			Arrays.deepToString(kthPermutation(new Object[] {0,1,2,3,4,5,6,7,8,9}, 1000000-1));
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
	}

}
