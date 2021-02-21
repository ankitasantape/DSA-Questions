package Day7;
/* Approach 1: Order-Agnostic Binary Search
 * Problem statement
Given a sorted array of numbers, find out if a given number key is present in the array.
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.
Write a function to return the index of the key if it is present in the array, otherwise return -1.
Example-1: Input: [1, 2, 3, 4, 5, 6, 7], key = 5, Output: 4
Example-2: Input: [10, 6, 4], key = 10, Output: 0
Solution
To make things simple, let’s first solve this problem assuming that the input array is sorted in ascending order.
These are the steps for binary search:
Step 1
Let’s assume start points to the first index and end points to the last index of the input array (let’s call it arr). This means: int start = 0; int end = arr.length — 1;
Step 2
First, we will find the middle of start and end.
An easy way to find the middle would be: middle=(start+end)/2.
For Java and C++, this equation will work most of the time, but when start or end is large, this equation will give us the wrong result due to integer overflow.
Imagine that start is equal to the maximum range of an integer (e.g., for Java: int start = Integer.MAX_VALUE). Now, adding anything to start will result in an integer overflow. As we need to add both numbers first to evaluate our equation, an overflow might occur.
The safest way to find the middle of two numbers without getting an overflow is as follows: middle = start + (end-start)/2.
Step 3
Next, we will see if the key is equal to the number at the index middle. If it is equal, we return middle as the required index.
Step 4
If the key is not equal to the number at the index middle, we have to check two things:
If key < arr[middle], then we can conclude that the key will be smaller than all the numbers after the index middle, as the array is sorted in ascending order. Hence, we can reduce our search to end = mid - 1.
If key > arr[middle], we can conclude that the key will be greater than all numbers before the index middle, as the array is sorted in ascending order. Hence, we can reduce our search to start = mid + 1.
Step 5
We will repeat steps 2 to 4 with new ranges of start to end.
If, at any time, start becomes greater than end, this means that we can’t find the key in the input array, and we must return -1.
Here is the visual representation of the Binary Search for the first example:
Image for post
If the array is sorted in descending order, we have to update step 4 above because:
If key > arr[middle], then we can conclude that the key will be greater than all the numbers after the index middle, as the array is sorted in descending order. Hence, we can reduce our search to end = mid - 1.
If key < arr[middle], then we can conclude that the key will be smaller than all the numbers before the index middle, as the array is sorted in descending order. Hence, we can reduce our search to start = mid + 1.
Finally, how can we figure out the sort order of the input array?
We can compare the numbers pointed out by the start and end indexes to find the sort order. If arr[start] < arr[end], it means that the numbers are sorted in ascending order; otherwise, they are sorted in descending order.

Time and space complexity
As we are reducing the search range by half at every step, it means that the time complexity of our algorithm will be O(logN) where N is the total number of elements in the given array.
The algorithm runs in constant space O(1).

Code
Here is the Java code to solve this problem:
*/
public class OrderAgnosticBinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 6, 10 }, 10));
	    System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
	    System.out.println(search(new int[] { 10, 6, 4 }, 10));
	    System.out.println(search(new int[] { 10, 6, 4 }, 4));

	}

	private static int search(int[] arr, int x) {
		int start = 0, end = arr.length-1;
		boolean isAscending =  arr[start] < arr[end] ;
		while( start <= end ) {
			int mid = start + (end-start)/2;
			if( arr[mid] == x ) {
				return mid;
			}
			if(isAscending) {
				if( x < arr[mid] ) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if( x < arr[mid] ) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
