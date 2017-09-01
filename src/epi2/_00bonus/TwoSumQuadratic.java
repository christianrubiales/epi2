package epi2._00bonus;

/**
 * Two Sum. Brute force.
 * O(n^2)
 */
public class TwoSumQuadratic {
	
	static void twoSum(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i != j) {
					if (a[i] + a[j] == k) {
						System.out.println(a[i] + " + " + a[j] + " = " + k);
						return;
					}
				}
			}
		}
		System.out.println("None found.");
	}

	public static void main(String[] args) {
		twoSum(new int[] {10,9,8,7,6,5,4,3,2,1}, 11);
	}

}
