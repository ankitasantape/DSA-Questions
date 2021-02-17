package Day3;

import java.util.Scanner;

/*Maximum Product Subarray 
Easy Accuracy: 29.84% Submissions: 22863 Points: 2
Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.
Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is  6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 500
-102 <= Arri <= 102
*/
public class MaximumProductSubarray {
	static long maxProduct(int[] arr, int n) {
		if( n == 0 ) {
			return 0;
		}
        long min = 1;
        long max = 1;
        long res = 1;
        
        for( int i = 0; i < n; i++ ) {
        	if( arr[i] > 0 ) {
        		max *= arr[i]; 
        		min = Math.min(1 , arr[i]*min);
        	} else if( arr[i] == 0 ) {
        		// reset min & max to 1
        		min = max = 1;
        	} else {
        		// For negative number first swap min & max element
        		max = min; // max = -18
        		min = min + max - max; // min = 1 - 18 - (-18) = 1 - 18 + 18 = 1
        		min *= arr[i]; 
        		max = Math.min(1 , arr[i]*max);
        	}
        	res = Math.max(max, res);
        }
        return res;
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++ ) {
        	a[i] = s.nextInt();
        }
        System.out.println(maxProduct(a,n));
        s.close();
	}

}
