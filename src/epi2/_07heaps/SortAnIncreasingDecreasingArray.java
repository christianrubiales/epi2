package epi2._07heaps;

import java.util.Arrays;

// EPI Solution does not make much sense, simpler to just sort the whole array
public class SortAnIncreasingDecreasingArray {
	
	// reverse the decreasing subarrays, then merge the segments
	static void sortIncreasingDecreasingArray(Integer[] numbers) {
		boolean increasing = true;
		int start1 = 0;
		int end1 = 0;
		int start2 = 0;
		int end2 = 0;
		
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i+1]) {
				end1 = i;
				start2 = i+1;
				while (i < numbers.length - 1 && numbers[i] > numbers[i+1]) {
					i++;
				}
				end2 = i;
				reverse(numbers, start2, end2);
				start1 = i;
			}
		}
	}
	
	static void reverse(Integer[] numbers, int start, int end) {
		while (start < end) {
			Integer t = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = t;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		Integer[] numbers = {57,131,493,294,221,339,418,452,442,190};
		System.out.println(Arrays.deepToString(numbers));
		sortIncreasingDecreasingArray(numbers);
		System.out.println(Arrays.deepToString(numbers));
	}

}
