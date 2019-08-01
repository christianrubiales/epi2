package epi2._02arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FisherYates {
	
	static Integer[] fisherYatesRightToLeft(Integer[] a) {
		Random random = ThreadLocalRandom.current();
		for (int i = a.length; i > 1; i--) {
			int r = random.nextInt(i);
			int t = a[i-1];
			a[i-1] = a[r];
			a[r] = t;
		}
		
		return a;
	}
	
	static Integer[] fisherYatesLeftToRight(Integer[] a) {
		Random random = ThreadLocalRandom.current();
		for (int i = 0; i < a.length - 1; i++) {
			int r = i + random.nextInt(a.length - i);
			int t = a[i];
			a[i] = a[r];
			a[r] = t;
		}
		
		return a;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fisherYatesRightToLeft(new Integer[] {1,2,3,4,5,6,})));
		System.out.println(Arrays.deepToString(fisherYatesLeftToRight(new Integer[] {1,2,3,4,5,6,})));
	}

}
