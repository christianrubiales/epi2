package epi2._02arrays;

//A O(n) time and O(1) extra space Java program to
//sort an array according to given indexes

import java.util.Arrays;

class ZZZTest
{
	static int arr[] = new int[]{0, 1, 2, 3};
	static int index[] = new int[]{2,0,3,1};
	
	// Method to reorder elements of arr[] according
	// to index[]
	static void reorder()
	{
	    // Fix all elements one by one
	    for (int i=0; i<arr.length; i++)
	    {
	        // While index[i] and arr[i] are not fixed
	        while (index[i] != i)
	        {
	            // Store values of the target (or correct) 
	            // position before placing arr[i] there
	            int  oldTargetI  = index[index[i]];
	            int oldTargetE  = arr[index[i]];
	 
	            // Place arr[i] at its target (or correct)
	            // position. Also copy corrected index for
	            // new position
	            arr[index[i]] = arr[i];
	            index[index[i]] = index[i];
	 
	            // Copy old target values to arr[i] and
	            // index[i]
	            index[i] = oldTargetI;
	            arr[i]   = oldTargetE;
	        }
	    }
	}
	
	// Driver method to test the above function
	public static void main(String[] args) 
	{
		
		reorder();
		
		System.out.println("Reordered array is: ");
		System.out.println(Arrays.toString(arr));
		System.out.println("Modified Index array is:");
		System.out.println(Arrays.toString(index));
		
    }
}