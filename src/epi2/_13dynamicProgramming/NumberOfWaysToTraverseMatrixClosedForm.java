package epi2._13dynamicProgramming;

// (n+m-2) Choose (m-1) -> (n+m-2)!/((n+m-2 - m-1)!(m-1)!) - > (n+m-2)!/((n-1)!(m-1)!)
// @see http://joaoff.com/2008/01/20/a-square-grid-path-problem/
public class NumberOfWaysToTraverseMatrixClosedForm {
	
	static int fact(int n) {
		int f = 1;
		
		for (int i = 2; i <= n; i++) {
			f = f*i;
		}
		
		return f;
	}
	
	static int numberOfWays(int n, int m) {
		return fact(n+m-2)/(fact(n-1)*fact(m-1));
	}

	public static void main(String[] args) {
		System.out.println(numberOfWays(1, 1));// 1
		System.out.println(numberOfWays(2, 2));// 2
		System.out.println(numberOfWays(3, 3));// 6
		System.out.println(numberOfWays(4, 4));// 20
		System.out.println(numberOfWays(5, 5));// 70
	}

}
