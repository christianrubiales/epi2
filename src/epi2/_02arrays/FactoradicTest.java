package epi2._02arrays;

public class FactoradicTest {
	
	static void factoradicIntMax() {
		int i = 1;
		int x = Integer.MAX_VALUE;
		
		while (x != 0) {
			x /= i;
			i++;
		}
		
		System.out.println(i);
	}
	
	static void factoradicLongMax() {
		long i = 1;
		long x = Long.MAX_VALUE;
		
		while (x != 0) {
			x /= i;
			i++;
		}
		
		System.out.println(i);
	}

	public static void main(String[] args) {
		factoradicIntMax();//14
		factoradicLongMax();//22
	}

}
