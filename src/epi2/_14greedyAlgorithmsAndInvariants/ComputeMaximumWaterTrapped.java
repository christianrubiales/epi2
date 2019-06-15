package epi2._14greedyAlgorithmsAndInvariants;

public class ComputeMaximumWaterTrapped {
	
	// O(n)
	static int getMaximumTrappedWater(int[] heights) {
		int max = 0;
		int i = 0;
		int j = heights.length - 1;
		
		while (i < j) {
			int trapped = (j - i) * Math.min(heights[i], heights[j]);
			if (trapped > max) {
				max = trapped;
			}
			if (heights[i] > heights[j]) {
				j--;
			} else if (heights[i] < heights[j]) {
				i++;
			} else {
				i++;
				j--;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(getMaximumTrappedWater(new int[]{1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1}));//48

	}

}
