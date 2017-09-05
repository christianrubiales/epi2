package epi2._02arrays;

import java.util.ArrayList;
import java.util.List;

public class GeneratePrimes {
	
	// Sieve of Eratosthenes
	// try multiples of numbers from 2 to ceil(sqrt(max))
	// O(n log log n)
	static List<Integer> primes(int max) {
		List<Integer> primes = new ArrayList<>();
		
		if (max > 1) {
			boolean[] sieve = new boolean[max+1];
			sieve[0] = false;
			sieve[1] = false;
			
			// initialize all to true
			for (int i = 2; i < sieve.length; i++) {
				sieve[i] = true;
			}
			
			// try multiples of 2 to ceil(sqrt(max))
			int root = (int) Math.ceil(Math.sqrt(max));
			for (int i = 2; i <= root; i++) {
				for (int j = i + i; j <= max; j += i) {
					sieve[j] = false;
				}
			}
			
			// get the primes
			for (int i = 2; i < sieve.length; i++) {
				if (sieve[i]) {
					primes.add(i);
				}
			}
		}
		
		return primes;
	}

	public static void main(String[] args) {
		System.out.println(primes(0));//[]
		System.out.println(primes(1));//[]
		System.out.println(primes(2));//[2]
		System.out.println(primes(3));//[2,3]
		System.out.println(primes(4));//[2,3]
		System.out.println(primes(5));//[2,3,5]
		System.out.println(primes(6));//[2,3,5]
		System.out.println(primes(7));//[2,3,5,7]
		System.out.println(primes(8));//[2,3,5,7]
		System.out.println(primes(9));//[2,3,5,7]
		System.out.println(primes(10));//[2,3,5,7]
		System.out.println(primes(11));//[2,3,5,7,11]

	}

}
