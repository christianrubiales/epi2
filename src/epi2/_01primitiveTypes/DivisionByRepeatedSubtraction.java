package epi2._01primitiveTypes;

public class DivisionByRepeatedSubtraction {
	
	static long divide(long x, long y) {
		long count = 0;
		
		while (x >= y) {
			x -= y;
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		  System.out.println(divide(Integer.MAX_VALUE, 1));// 2147483647

	}

}
