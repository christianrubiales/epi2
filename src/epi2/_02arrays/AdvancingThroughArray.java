package epi2._02arrays;

public class AdvancingThroughArray {
	
	static boolean canReachEnd(Integer[] maxAdvanceSteps) {
		int furthestReachSoFar = 0;
		int lastIndex = maxAdvanceSteps.length - 1;
		
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps[i]);
		}
		
		return furthestReachSoFar >= lastIndex;
	}

	public static void main(String[] args) {
		System.out.println(canReachEnd(new Integer[] {3,3,1,0,2,0,1})); // true
		System.out.println(canReachEnd(new Integer[] {3,2,0,0,2,0,1})); // false
		System.out.println(canReachEnd(new Integer[] {2,4,1,1,0,2,3})); // true
	}

}
