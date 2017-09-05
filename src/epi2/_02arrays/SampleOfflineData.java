package epi2._02arrays;

import java.util.Arrays;
import java.util.Random;

// the first k elements must be the random sample
public class SampleOfflineData {
	
	// Fisher-Yates left to right instead of right to left
	static Integer[] randomSample(Integer[] data, int k) {
		Random random = new Random();
		for (int i = 0; i < k; i++) {
			int r = i + random.nextInt(data.length - i);
			int t = data[i];
			data[i] = data[r];
			data[r] = t;
		}
		
		return data;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(randomSample(new Integer[] {1,2,3,4,5,6}, 3)));
	}

}
