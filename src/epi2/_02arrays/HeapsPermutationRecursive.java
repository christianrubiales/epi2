package epi2._02arrays;

public class HeapsPermutationRecursive {

	static void generate(char[] A) {
		generate(A.length - 1, A);
	}
	
	static void generate(int n, char[] A) {
		if (n == 0) {
			System.out.println(A);
		} else {
			for (int i = 0; i <= n; i++) {
				generate(n - 1, A);
				int j = 0;
				if (n % 2 == 0) {
					j = 1;
				} else {
					j = i;
				}
				swap(A, n, j);
			}
		}
	}
	
	static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		generate("ABC".toCharArray());
		generate("1234".toCharArray());
	}
}
