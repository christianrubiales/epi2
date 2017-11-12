package epi2._14greedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @see https://en.wikipedia.org/wiki/3SUM#Quadratic_algorithm
public class HasThreeSumDistinct {
	
	static boolean hasThreeSum(int[] A, int sum) {
		if (A == null || A.length < 3) {
			return false;
		}
		
		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {
			int a = A[i];
			int start = i+1;
			int end = A.length - 1;
			
			while (start < end) {
				int b = A[start];
				int c = A[end];
				
				if (a+b+c == sum) {
					return true;
				} else if (a+b+c > sum) {
					end--;
				} else {
					start++;
				}
			}
		}
		
		return false;
	}
	
	static List<List<Integer>> getThreeSum(int[] A, int sum) {
		List<List<Integer>> triplets = new ArrayList<>();
		if (A == null || A.length < 3) {
			return triplets;
		}
		
		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {
			int a = A[i];
			int start = i+1;
			int end = A.length - 1;
			
			while (start < end) {
				int b = A[start];
				int c = A[end];
				
				if (a+b+c == sum) {
					triplets.add(Arrays.asList(a,b,c));
					
					if (b == A[start+1]) {
						start++;
					} else {
						end--;
					}
				} else if (a+b+c > sum) {
					end--;
				} else {
					start++;
				}
			}
		}
		
		return triplets;
	}

	public static void main(String[] args) {
		int[] A = new int[] {-3,-2,-1,0,1,2,3};
		for (int i = -10; i < 10; i++) {
			System.out.println(i + " : " + hasThreeSum(A, i));
		}
		System.out.println();
		
		for (int i = -10; i < 10; i++) {
			System.out.println(i + " : " + getThreeSum(A, i));
		}
	}

}
