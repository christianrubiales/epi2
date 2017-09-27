package epi2._02arrays;

public class BuyAndSellStockOnce {
	
	static Double buyAndSellStockOnce(Double[] prices) {
		Double minPriceSoFar = Double.MAX_VALUE;
		Double maxProfit = 0.0d;
		
		// get max profit possible for each day
		for (int i = 0; i < prices.length; i++) {
			minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(buyAndSellStockOnce(new Double[] {12d,11d,13d,9d,12d,8d,14d,13d,15d})); //7
		System.out.println(buyAndSellStockOnce(new Double[] {1d,2d,3d,4d})); // 3
		System.out.println(buyAndSellStockOnce(new Double[] {1d,2d,3d,2d,4d})); // 3
		System.out.println(buyAndSellStockOnce(new Double[] {1d,2d,4d,2d,3d,2d,4d})); // 5
		System.out.println(buyAndSellStockOnce(new Double[] {2d,30d,15d,10d,8d,25d,80d})); // 78
		System.out.println(buyAndSellStockOnce(new Double[] {100d,30d,15d,10d,8d,25d,80d})); // 72
	}

}
