package epi2._02arrays;

public class BuyAndSellStockTwice {
	
	static Double buyAndSellStockTwice(Double[] prices) {
		Double minPriceSoFar = Double.MAX_VALUE;
		Double maxProfit = 0.0d;
		Double[] firstProfits = new Double[prices.length];
		
		// get max profit possible for each day
		for (int i = 0; i < prices.length; i++) {
			minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
			firstProfits[i] = maxProfit;
		}
		
		// get the max profit if buying again after previous sell
		Double maxPriceSoFar = Double.MIN_VALUE;
		for (int i = prices.length - 1; i > 0; i--) {
			
			// going backwards, take note of the max price so far
			maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
			
			// maxProfit candidate -> maxPriceSoFar - current price + profit from earlier day
			maxProfit = Math.max(maxProfit, maxPriceSoFar - prices[i] + firstProfits[i-1]);
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(buyAndSellStockTwice(new Double[] {12d,11d,13d,9d,12d,8d,14d,13d,15d})); //10
		System.out.println(buyAndSellStockTwice(new Double[] {1d,2d,3d,4d})); // 3
		System.out.println(buyAndSellStockTwice(new Double[] {1d,2d,3d,2d,4d})); // 4
		System.out.println(buyAndSellStockTwice(new Double[] {1d,2d,4d,2d,3d,2d,4d})); // 5
		System.out.println(buyAndSellStockTwice(new Double[] {2d,30d,15d,10d,8d,25d,80d})); // 100
		System.out.println(buyAndSellStockTwice(new Double[] {100d,30d,15d,10d,8d,25d,80d})); // 72
	}

}
