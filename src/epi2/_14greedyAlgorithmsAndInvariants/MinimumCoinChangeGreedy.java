package epi2._14greedyAlgorithmsAndInvariants;

public class MinimumCoinChangeGreedy {
	
//	static final int[] COINS = {100,50,25,10,5,1};
	static final int[] COINS = {1,5,10,25,50,100};
	
	static int minCoinChange(int amount) {
		int coins = 0;
		
		for (int i = COINS.length - 1; i > -1; i--) {
			coins += amount / COINS[i];
			amount %= COINS[i];
		}
		
		return coins;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.println(i + " : " + minCoinChange(i));
		}
	}

}
