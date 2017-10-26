package epi2._03strings;

public class SpreadsheetColumnEncoding {
	
	static String toSpreadsheetColumn(int n) {
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			n--;
			sb.append((char) ('A' + (n % 26)));
			n /= 26;
		}
		
		return sb.reverse().toString();
	}
	
	static int decodeSpreadsheetColumn(String s) {
		int decoded = 0;
		
		for (int i = 0; i < s.length(); i++) {
			decoded = decoded * 26 + s.charAt(i) - 'A' + 1;
		}
		
		return decoded;
	}

	public static void main(String[] args) {
		System.out.println(decodeSpreadsheetColumn("A"));//1
		System.out.println(decodeSpreadsheetColumn("Z"));//26
		System.out.println(decodeSpreadsheetColumn("AA"));//27
		System.out.println(decodeSpreadsheetColumn("AB"));//28
		System.out.println(decodeSpreadsheetColumn("AZ"));//52
		System.out.println(decodeSpreadsheetColumn("BA"));//53
		
		System.out.println(toSpreadsheetColumn(1));//A
		System.out.println(toSpreadsheetColumn(26));//Z
		System.out.println(toSpreadsheetColumn(27));//AA
		System.out.println(toSpreadsheetColumn(28));//AB
		System.out.println(toSpreadsheetColumn(52));//AZ
		System.out.println(toSpreadsheetColumn(53));//BA
	}

}
