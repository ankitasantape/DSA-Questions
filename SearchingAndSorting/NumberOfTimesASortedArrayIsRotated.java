package Day7;

import java.util.Scanner;
/*Find the Rotation Count in Rotated Sorted array
Difficulty Level : Easy
Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:
Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after 
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
*/
public class NumberOfTimesASortedArrayIsRotated {
    /*Method 1 (Using linear search)

If we take closer look at examples, we can notice that the number of rotations is equal to index of minimum 
element. A simple linear solution is to find minimum element and returns its index.
Time Complexity : O(n)  */
	public static int countRotations(int arr[], int n) {
		int min = arr[0], min_idx = -1;
		for( int i = 1; i < n; i++ ) {
			if( arr[i] < min ) {
				min = arr[i];
				min_idx = i;
			}
		}
		return min_idx;
	}
	/* Time Complexity : O(logn) */
	public static int countRotations2(int arr[], int n) {
	    int start = 0, end = n-1;
	    while( start <= end ) {
	    	int mid = start + (end - start)/2;
	    	int next = ( mid + 1 )% n , prev = ( mid + n - 1 )% n ;
	    	
	    	if( arr[prev] >= arr[mid] && arr[mid] <= arr[next] ) {
	    	
	    		return mid;
	    	
	    	} else if( arr[start] <= arr[mid] ) {
	    	
	    		start = mid + 1;
	    	
	    	}else {
	    	
	    		end = mid - 1;
	    	}
	    }
	    return -1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for( int i = 0 ; i<n ; i++ ) {
			a[i] = s.nextInt();
		}
		System.out.println(countRotations(a,n));
		System.out.println(countRotations2(a,n));
		s.close();
	}

}
