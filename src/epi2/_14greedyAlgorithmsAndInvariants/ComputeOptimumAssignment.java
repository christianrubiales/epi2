package epi2._14greedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeOptimumAssignment {
	
	static class Pair {
		int task1;
		int task2;
	}

	// O(nlogn)
	static List<Pair> computeOptimumAssignment(int[] tasks) {
		List<Pair> assignments = new ArrayList<>();
		
		if (tasks != null) {
			Arrays.sort(tasks);
			for (int i = 0; i < tasks.length/2; i++) {
				Pair pair = new Pair();
				pair.task1 = tasks[i];
				pair.task2 = tasks[tasks.length - i - 1];
				assignments.add(pair);
			}
			if (tasks.length % 2 != 0) {
				Pair pair = new Pair();
				pair.task1 = tasks[tasks.length/2];
				assignments.add(pair);
			}
		}
		
		return assignments;
	}
	
	static void print(List<Pair> assignments) {
		for (Pair pair : assignments) {
			System.out.printf("[%d,%d],", pair.task1, pair.task2);
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
