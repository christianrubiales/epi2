package epi2._02arrays;

public class BuyAndSellStockAnyNumberOfTimes {
	
	static int maxProfit(int[] prices) {
		int maxProfit = 0;
		
		// if current price is greater than price a day before,
		// buy from price a day before and sell at price of current day
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				maxProfit += prices[i] - prices[i-1];
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {5,1,2,3,4})); //3
		System.out.println(maxProfit(new int[] {12,41,54,12,20})); //50
	}

}
