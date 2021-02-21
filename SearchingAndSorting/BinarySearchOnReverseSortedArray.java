package Day7;
/*Search an element in a reverse sorted array
Difficulty Level : Easy
 Last Updated : 01 Feb, 2021
Given an array arr[] sorted in decreasing order, and an integer X, the task is to check if X is present in the given array or not. If X is present in the array, print its index ( 0-based indexing). Otherwise, print -1.

Examples: 

Input: arr[] = {5, 4, 3, 2, 1}, X = 4
Output: 1
Explanation: Element X (= 4) is present at index 1.
Therefore, the required output is 1.

Input: arr[] = {10, 8, 2, -9}, X = 5
Output: -1
Explanation: Element X (= 5) is not present in the array.
Therefore, the required output is -1.

Naive Approach: The simplest approach to solve the problem is to traverse the array and for each element, 
check if it is equal to X or not. If any element is found to satisfy that condition,
print the index of that element. Otherwise print -1. 

*Time Complexity: O(N) 
Auxiliary Space: O(1)

Efficient Approach: To solve the problem, the idea is to use Binary Search based on the approach discussed in the article search an element in a sorted array. Follow the steps below to solve the problem: 

Compare X with the middle element.
If X matches with the middle element (arr[mid]), return the index mid.
If X is found to be greater than the arr[mid], then X can only lie in the subarray [mid + 1, end]. So search for X in the subarray {arr[mid + 1], .., arr[end]} .
Otherwise, search in the subarray {arr[start], …., arr[mid]} 
*/
public class BinarySearchOnReverseSortedArray {

	public static void main(String[] args) {
		 int arr[] = { 5, 4, 3, 2, 1 };
	        int N = arr.length;
	        int X = 5;
	        System.out.println("X is present at index : " +
	            binarySearch(arr, N, X));
	}

	private static int binarySearch(int[] arr, int n, int x) {
		int start = 0, end = n;
		while( start <= end ) {
			int mid = start + ( end - start )/2;
			if( arr[mid] == x ) {
				return mid;
			}else if( arr[mid] > x ){
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		return -1;
	}

}
