package epi2._02arrays;

import java.util.Arrays;

public class ApplyPermutation {

	// not space efficient
	// O(n) time, O(n) space
	static Object[] applyPermutation(Object[] array, int[] permutation) {
		Object[] result = new Object[array.length];
		
		for (int i = 0; i < array.length; i++) {
			result[permutation[i]] = array[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Object[] array = new Object[] {"a","b","c","d",};
		System.out.println(Arrays.deepToString(applyPermutation(array, new int[] {2,0,1,3})));//b,c,a,d
		System.out.println(Arrays.deepToString(applyPermutation(array, new int[] {2,0,3,1})));//b,d,a,c
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {0,1,2})));//a,b,c
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {0,2,1})));//a,c,b
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {2,0,1})));//b,c,a
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {2,1,0})));//c,b,a
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {1,2,0})));//c,a,b
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new int[] {1,0,2})));//b,a,c
	}

}
