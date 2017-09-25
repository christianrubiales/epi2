package epi2._02arrays;

public class HeapsPermutationIterative {
	
	static void generate(char[] A) {
		char[] c = new char[A.length];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
		
		System.out.println(A);
		
		int i = 0;
		while (i < A.length) {
			if (c[i] < i) {
				if (i % 2 == 0) {
					swap(A, 0, i);
				} else {
					swap(A, i, 0);
				}
				
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
//		generate("ABC".toCharArray());
//		generate("123".toCharArray());
//		generate("1234".toCharArray());
		generate("ABCD".toCharArray());
//		generate("112".toCharArray());
	}
}
