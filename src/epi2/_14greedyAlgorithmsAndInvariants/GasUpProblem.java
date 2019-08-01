package epi2._14greedyAlgorithmsAndInvariants;

public class GasUpProblem {
	
	static final int MPG = 20;
	
	static int findAmpleCity(int[] gallons, int[] distances) {
		int remainingGallons = 0;
		int city = 0;
		int minRemainingGallons = 0;
		
		for (int i = 1; i < gallons.length; i++) {
			remainingGallons += gallons[i-1] - distances[i-1]/MPG;
			if (remainingGallons < minRemainingGallons) {
				city = i;
				minRemainingGallons = remainingGallons;
			}
		}
		
		return city;
	}

	public static void main(String[] args) {
		int[] gallons = {50,20,5,30,25,10,10};
		int[] distances = {900,600,200,400,600,200,100};
		System.out.println(findAmpleCity(gallons, distances));//3
	}

}
