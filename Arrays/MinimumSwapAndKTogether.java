package Day5;
import java.util.Scanner;

/*Minimum swaps and K together 
Medium Accuracy: 40.06% Submissions: 2732 Points: 4
Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

Example 1:
Input : arr[ ] = {2, 1, 5, 6, 3} and K = 3
Output : 1
Explanation:
To bring elements 2, 1, 3 together, swap element '5' with '3'
such that final array will be- arr[] = {2, 1, 3, 6, 5}
Example 2:

Input : arr[ ] = {2, 7, 9, 5, 8, 7, 4} and K = 6 
Output :  2 
 
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i], K ≤107
*/
public class MinimumSwapAndKTogether {
	public static int minSwap(int arr[], int n, int k) {
         // count elements which is less than or equal to k  
		int good = 0;
		for( int i = 0; i < n; i++ ) {
			if( arr[i] <= k ) {
				good++;
			}
		}
		int bad = 0, i = 0;
		// count elements from window of size 'good'
		while( i < good ) {
			if( arr[i] > k ) {
				bad++;
			}
			i++;
		}
		int ans = bad, j ;
		for( i = 0, j = good; j < n; j++, i++ ) {
			if( arr[i] > k ) {
				bad--;
			}
			if( arr[j] > k ) {
				bad++;
			}
			ans = Math.min(ans, bad);
		}
		return ans;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for( int i = 0; i < n ; i++ ) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(minSwap(a,n,k));
		sc.close();
	}
}
