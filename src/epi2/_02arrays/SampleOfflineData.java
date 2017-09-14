package epi2._02arrays;

import java.util.Arrays;
import java.util.Random;

public class SampleOfflineData {
	
	// Fisher-Yates left to right instead of right to left
	static Integer[] randomSample(Integer[] data, int k) {
		Integer[] a = Arrays.copyOf(data, data.length);
		Integer[] sample = new Integer[k];
		Random random = new Random();

		for (int i = 0; i < k; i++) {
			int r = i + random.nextInt(a.length - i);
			int t = a[i];
			a[i] = a[r];
			a[r] = t;
			sample[i] = a[i];
		}
		
		return sample;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(randomSample(new Integer[] {1,2,3,4,5,6}, 3)));
	}

}
