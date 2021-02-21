package Day7;

import java.util.Scanner;
/*Search an element in a sorted and rotated array
Difficulty Level : Medium
 Last Updated : 28 Jul, 2020
An element in a sorted array can be found in O(log n) time via binary search. 
But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
Devise a way to find an element in the rotated array in O(log n) time.
Example:

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3
*/
public class FindAnElementInARotated {

	static int search(int arr[], int l, int h, int key) 
    { 
		int index = countRotations( arr, arr.length);
		int left = binarySearch( arr, l, index - 1, key);
		int right = binarySearch( arr, index, arr.length-1, key );
		if( left >= 0 ) {
			return left;
		}
		if( right >= 0 ) {
			return right;
		}
		return -1;
    }
	
	private static int binarySearch(int[] arr, int start, int end, int key) {
		while( start <= end ) {
			int mid = start + (end - start)/2;
			if( arr[mid] == key ) {
				return mid;
			} else if( arr[mid] > key ) {
				end = mid - 1; 
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int countRotations(int arr[], int n) {
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
		Scanner  s= new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for( int i = 0; i < n; i++ ) {
        	a[i] = s.nextInt();
        }
        int key = s.nextInt();
        System.out.println("Found at index : " + search(a, 0, n-1, key));
        s.close();
	}

}
