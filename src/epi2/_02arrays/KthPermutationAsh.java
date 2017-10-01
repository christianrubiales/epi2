package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class KthPermutationAsh {
	
    // function to get Factoradic representation of a number,n.
    static Integer[] getFactoradic(int n) {
    		Integer[] factoradic = new Integer[13];
        int i = 1;
        while (n != 0) {
            factoradic[13 - i] = n % i;
            n = n / i;
            i++;
        }
        return factoradic;
    }
 
    // function takes a String,str and Factoradic representation of a number n.
    // returns the nth lexicographic permutaion of character array, str.
    static String getPermutation(char[] str, Integer[] factoradic) {
        Arrays.sort(str);
        ArrayList<Character> res = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
        int pos;
        char c;
        String perm = "";
        boolean[] used = new boolean[str.length]; // by default values are initialised to false.
        for (int i = 0; i < factoradic.length; i++) {
            pos = factoradic[i];
            c = getUnusedCharAtPos(str, pos, used);
            res.add(c);
        }
        for (char some_c : res) {
            sb.append(some_c);
        }
        return (sb.toString());
    }
 
    //function to get the yet unused character at a given position in a character array.
    private static char getUnusedCharAtPos(char[] str, int pos, boolean[] used) {
        int count = -1;
        for (int i = 0; i < str.length; i++) {
            if (!used[i]) {
                count++;
                if (count == pos) {
                    used[i] = true;
                    return str[i];
                }
            }
        }
        return ' ';
    }
    
	public static void main(String[] args) {
        char[] str = "abcd".toCharArray();
        Integer[] f = new Integer[13];
        for (int i = 1; i <= 24; i++) {
            f = getFactoradic(i-1);
//            System.out.println(Arrays.deepToString(f));
            System.out.println(getPermutation(str, f));
        }
	}

}
