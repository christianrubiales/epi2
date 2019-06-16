package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Stack;

// @see https://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
public class ComputeLargestRectangleUnderSkyline {
	
	static int getLargestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();// contains indices
	 	int max = 0;

		int i = 0;
		while (i < heights.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int top = stack.pop();
				int height = heights[top];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(height * width, max);
			}
	 
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int height = heights[top];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(height * width, max);
		}
	 
		return max;
	}

	public static void main(String[] args) {
		System.out.println(getLargestRectangleArea(new int[] {1,2,3}));//4
		System.out.println(getLargestRectangleArea(new int[] {3,2,1}));//4
		System.out.println(getLargestRectangleArea(new int[] {6, 2, 5, 4, 5, 1, 6}));//12
		System.out.println(getLargestRectangleArea(new int[] {100,1,1,1}));//100
	}

}
