package epi2._02arrays;

public class BuyAndSellStockTwice {
	
	static Double buyAndSellStockTwice(Double[] prices) {
		Double maxProfit = 0.0d;
		Double[] firstBuyAndSellProfits = new Double[prices.length];
		Double minPriceSoFar = Double.MAX_VALUE;
		
		// get max profit possible for each day
		for (int i = 0; i < prices.length; i++) {
			minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
			firstBuyAndSellProfits[i] = maxProfit;
		}
		
		// get the max profit if buying again for each day
		Double maxPriceSoFar = Double.MIN_VALUE;
		for (int i = prices.length - 1; i > 0; i--) {
			maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, maxPriceSoFar - prices[i] + firstBuyAndSellProfits[i-1]);
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(buyAndSellStockTwice(new Double[] {12d,11d,13d,9d,12d,8d,14d,13d,15d}));
	}

}
