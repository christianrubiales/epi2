package epi2._14greedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeOptimumAssignment {

	// O(nlogn)
	static List<int[]> computeOptimumAssignment(int[] tasks) {
		List<int[]> assignments = new ArrayList<>();
		
		if (tasks != null) {
			Arrays.sort(tasks);
			for (int i = 0; i < tasks.length/2; i++) {
				int[] pair = new int[2];
				pair[0] = tasks[i];
				pair[1] = tasks[tasks.length - i - 1];
				assignments.add(pair);
			}
			/*if (tasks.length % 2 != 0) {
				assignments.add(new int[] {tasks[tasks.length/2], 0});
			}*/
		}
		
		return assignments;
	}
	
	static void print(List<int[]> assignments) {
		for (int[] pair : assignments) {
			System.out.printf("[%d,%d],", pair[0], pair[1]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(computeOptimumAssignment(null));
		print(computeOptimumAssignment(new int[] {}));
		print(computeOptimumAssignment(new int[] {1}));//[1,0],
		print(computeOptimumAssignment(new int[] {1,2,3}));//[1,3],[2,0],
		print(computeOptimumAssignment(new int[] {5,2,1,6,4,4}));//[1,6],[2,5],[4,4],
		print(computeOptimumAssignment(new int[] {1,8,9,10}));//[1,10],[8,9],
	}

}
