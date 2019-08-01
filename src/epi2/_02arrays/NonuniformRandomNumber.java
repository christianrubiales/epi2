package epi2._02arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NonuniformRandomNumber {
	
	// use prefix sum of probabilities and Java binarySearch
	static int nonuniformRandom(int[] values, double[] probabilities) {
		// generate a prefix sum of probabilities
		double[] prefixSum = new double[probabilities.length];
		prefixSum[0] = probabilities[0];
		for (int i = 1; i < probabilities.length; i++) {
			prefixSum[i] = prefixSum[i-1] + probabilities[i];
		}
		
		Random random = ThreadLocalRandom.current();
		double r = random.nextDouble();
		int index = Arrays.binarySearch(prefixSum, r);
		
		// binarySearch returns the negative index of where the element should be inserted
		if (index < 0) {
			return values[(Math.abs(index) - 1)];
		} else {
			return values[index];
		}
	}

	public static void main(String[] args) {
		double[] probabilities = new double[] {9d/18, 6d/18, 2d/18, 1d/18};
		Integer[] counts = new Integer[12];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}
		
		for (int i = 0; i < 1000000; i++) {
			counts[nonuniformRandom(new int[] {3,5,7,11}, probabilities)]++;
		}
		System.out.println(Arrays.deepToString(counts));
	}

}
