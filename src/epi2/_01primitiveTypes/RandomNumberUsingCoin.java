package epi2._01primitiveTypes;

import java.util.Random;

public class RandomNumberUsingCoin {
	
	// generate random number from 0 to n-1 using a coin
	// shift previous generated once and concatenate toss outcomes to generate the random number
	// if max tosses already and generated number is >= n, repeat from the start
	static int random(int n) {
		int max = 1;
		int generated = 0;
		int i = 1;
		
		// get max
		while (max < n) {
			max <<= 1;
		}
		
		while (i < max) {
			// shift previous and concatenate new toss
			generated = (generated << 1) | coinToss();
			i <<= 1;
			
			// reset
			if (i == max && generated >= n) {
				System.out.println("reset: " + generated);
				generated = 0;
				i = 1;
			}
		}
		
		return generated;
	}

	static final Random random = new Random();
	
	// return 0 for head and 1 for tail
	static int coinToss() {
		int toss = random.nextInt(2);
		System.out.println("toss: "  + toss);
		return toss;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("generated: " + random(9));
			System.out.println();
		}

	}

}
