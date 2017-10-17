package epi2._01primitiveTypes;

import java.math.BigInteger;

public class BigIntegerMultiplication {
	
	static String multiply(String x, String y) {
		return new BigInteger(x).multiply(new BigInteger(y)).toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("123456789123456789123456789", "987654321987654321987654321"));
	}

}
