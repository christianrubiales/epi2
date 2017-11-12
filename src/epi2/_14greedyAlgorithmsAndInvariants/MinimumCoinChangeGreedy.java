package epi2._14greedyAlgorithmsAndInvariants;

public class MinimumCoinChangeGreedy {
	
	static final int[] COINS = {100,50,25,10,5,1};
	
	static int minCoinChange(int amount) {
		int coins = 0;
		
		for (int i = 0; i < COINS.length; i++) {
			while (amount >= COINS[i]) {
				coins += amount / COINS[i];
				amount %= COINS[i];
			}
		}
		
		return coins;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.println(i + " : " + minCoinChange(i));
		}
	}

}