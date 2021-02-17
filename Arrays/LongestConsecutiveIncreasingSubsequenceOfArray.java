package Day3;

import java.util.HashMap;
import java.util.Scanner;

/*Longest consecutive subsequence 
Medium Accuracy: 48.9% Submissions: 27044 Points: 4
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Constraints:
1 <= N <= 105
0 <= a[i] <= 105
*/
public class LongestConsecutiveIncreasingSubsequenceOfArray {
  
	public static void longestConsecutiveIncreasingSubsequence( int a[], int n) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for( int val : a ) {
			map.put( val , true );
		}
		for( int val : a ) {
			if( map.containsKey(val - 1)) {
				map.put( val , false );
			}
		}
		int maxStartPtr = 0, maxLen = 0;
		for( int val : a ) {
			if( map.get(val) == true ) {
				int tempLen = 1;
				int tempStartPtr = val;
				while( map.containsKey(tempStartPtr + tempLen)) {
					tempLen++;
				}
				if( tempLen > maxLen ) {
					maxStartPtr = tempStartPtr;
					maxLen = tempLen;
				}
			}
		}
		
		for( int i = 0; i < maxLen ; i++ ) {
			System.out.println( maxStartPtr + i );
		}
	}
	
	public static void main(String[] args) {
	      Scanner s = new Scanner(System.in);
	      int n = s.nextInt();
	      int a[] = new int[n];
	      for( int i = 0; i < n; i++ ) {
	    	  a[i] = s.nextInt();
	      }
	      longestConsecutiveIncreasingSubsequence( a, n );
	      s.close();
          
	}

}
