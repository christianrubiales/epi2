package epi2._02arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SampleOnlineData {
	
	// O(n) time, O(k) space
	static Integer[] randomSample(Iterator<Integer> iter, int k) {
		// initially copy the first k data as sample
		Integer[] sample = new Integer[k];
		for (int i = 0; i < k && iter.hasNext(); i++) {
			sample[i] = iter.next();
		}
		
		// each incoming element may or may not replace any in the current sample
		int n = k;
		Random random = ThreadLocalRandom.current();
		while (iter.hasNext()) {
			Integer x = iter.next();
			n++;
			int r = random.nextInt(n);
			
			if (r < k) {
				sample[r] = x;
			}
		}
		
		return sample;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(randomSample(Arrays.asList(1,2,3,4,5,6,7,8,9,0).iterator(), 2)));
	}

}
