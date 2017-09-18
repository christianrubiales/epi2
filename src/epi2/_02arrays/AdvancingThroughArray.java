package epi2._02arrays;

public class AdvancingThroughArray {
	
	static boolean canReachEnd(Integer[] maxAdvanceSteps) {
		int maxSoFar = 0;
		int lastIndex = maxAdvanceSteps.length - 1;
		
		for (int i = 0; i <= maxSoFar && maxSoFar < lastIndex; i++) {
			maxSoFar = Math.max(maxSoFar, i + maxAdvanceSteps[i]);
		}
		
		return maxSoFar >= lastIndex;
	}

	public static void main(String[] args) {
		System.out.println(canReachEnd(new Integer[] {3,3,1,0,2,0,1})); // true
		System.out.println(canReachEnd(new Integer[] {3,2,0,0,2,0,1})); // false
		System.out.println(canReachEnd(new Integer[] {2,4,1,1,0,2,3})); // true
	}

}
