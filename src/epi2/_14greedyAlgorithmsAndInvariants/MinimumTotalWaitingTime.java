package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class MinimumTotalWaitingTime {
	
	// O(nlogn)
	static int getMinimumTotalWaitingTime(int[] serviceTimes) {
		Arrays.sort(serviceTimes);
		
		int minimum = 0;
		int waitingTime = serviceTimes[0];
		
		for (int i = 1; i < serviceTimes.length; i++) {
			minimum += waitingTime;
			waitingTime += serviceTimes[i];
		}
		
		return minimum;
	}

	public static void main(String[] args) {
		System.out.println(getMinimumTotalWaitingTime(new int[] {2,5,1,3}));//10
	}

}
