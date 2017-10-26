package epi2._03strings;

public class BaseConversion {
	
	public static String convertBase(String s, int base1, int base2) {
		boolean isNegative = s.charAt(0) == '-';
		int x = 0;
		for (int i = (isNegative ? 1 : 0); i < s.length(); ++i) {
			x *= base1;
			x += Character.isDigit(s.charAt(i)) 
					? s.charAt(i) - '0'
					: s.charAt(i) - 'A' + 10;
		}
		
		return (isNegative ? "-" : "") + (x == 0 ? "0" : decimalToOtherBase(x, base2));
	}

	private static String decimalToOtherBase(int d, int base) {
		if (d == 0) {
			return "";
		}
		
		return decimalToOtherBase(d / base, base) 
				+ (char) (d % base >= 10 
				? 'A' + d % base - 10 
				: '0' + d % base);
	}

	public static void main(String[] args) {
		System.out.println(decimalToOtherBase(10, 2));//
		System.out.println(decimalToOtherBase(35, 36));//Z

		System.out.println(convertBase("-1", 10, 2));
		System.out.println(convertBase("0", 10, 2));
		System.out.println(convertBase("1", 10, 2));
	}

}
