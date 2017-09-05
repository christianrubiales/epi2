package epi2._02arrays;

public class BuyAndSellStockOnce {
	
	// take note of the current minimum price as the array is traversed from left to right
	// take note of the difference of between the current price and the current minimum price
	static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for (int price : prices) {
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
		}
		
		return maxProfit;
	}
	
	static void print(int[] a, int max) {
		System.out.print("array: [");
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.println("], max: " + max);
	}

	public static void main(String[] args) {
		int[] a = new int[] {310,315,275,295,260,270,290,230,255,250};
		print(a, maxProfit(a));//30
	}

}
