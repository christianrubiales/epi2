package epi2._02arrays;

public class HeapsPermutationIterative {
	
	static void generate(char[] A) {
		int[] c = new int[A.length];
		System.out.println(A);
		
		int i = 0;
		while (i < A.length) {
			if (c[i] < i) {
				swap(A, 0, i);
				System.out.println(A);
				
				c[i]++;
				i = 0;
			} else {
				c[i] = 0;
				i++;
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
		generate("123".toCharArray());
		generate("1234".toCharArray());
		generate("ABCD".toCharArray());
		generate("112".toCharArray());
	}
}
