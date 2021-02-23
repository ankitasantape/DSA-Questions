package Day8;
/*Find a peak element
Difficulty Level : Medium
Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours. For corner elements, we need to consider only one neighbour. 

Example:

Input: array[]= {5, 10, 20, 15}
Output: 20
The element 20 has neighbours 10 and 15,
both of them are less than 20.

Input: array[] = {10, 20, 15, 2, 23, 90, 67}
Output: 20 or 90
The element 20 has neighbours 10 and 15, 
both of them are less than 20, similarly 90 has neighbous 23 and 67.
Following corner cases give better idea about the problem. 

If input array is sorted in strictly increasing order, the last element is always a peak element. For example, 50 is peak element in {10, 20, 30, 40, 50}.
If the input array is sorted in strictly decreasing order, the first element is always a peak element. 100 is the peak element in {100, 80, 60, 50, 20}.
If all elements of input array are same, every element is a peak element.
It is clear from the above examples that there is always a peak element in the input array.

Naive Approach: The array can be traversed and the element whose neighbours are less than that element can be returned.
Algorithm: 
If in the array, the first element is greater than the second or the last element is greater than the second last, print the respective element and terminate the program.
Else traverse the array from the second index to the second last index
If for an element array[i], it is greater than both its neighbours, i.e., array[i] > array[i-1] and array[i] > array[i+1], then print that element and terminate.
*/
public class PeakElement {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 20, 15 };
		System.out.println( "Peak Value is : "+peakValue(arr, arr.length));

	}

	private static int peakValue(int[] arr, int length) {
		int start = 0, end = length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (mid > 0 && mid < length - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return arr[mid];
				} else if (arr[mid - 1] > arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			
			} else if( mid == 0 ) {
				if( arr[0] > arr[1] ) {
					return 0;
				} else {
					return 1;
				}
			
			} else if( mid == length -1 ) {
				if( arr[length - 1] > arr[length - 2]) {
					return length - 1;
				} else {
					return length - 2;
				}
			}
		}
		return -1;
	}

}
