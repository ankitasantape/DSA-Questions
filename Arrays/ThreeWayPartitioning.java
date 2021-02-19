package Day5;
/*Three way partitioning 
Easy Accuracy: 50.02% Submissions: 23389 Points: 2
Given an array of size N and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.
Example 1:

Input: 
N = 5
A[] = {1, 2, 3, 3, 4}
[a, b] = [1, 2]
Output: 1
Explanation: One possible arrangement is:
{1, 2, 3, 3, 4}. If you return a valid
arrangement, output will be 1.

Example 2:

Input: N = 3 
A[] = {1, 2, 3}
[a, b] = [1, 3]
Output: 1
Explanation: One possible arrangement 
is: {1, 2, 3}. If you return a valid
arrangement, output will be 1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/
public class ThreeWayPartitioning {

	public static void main(String[] args) {

	    int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}; 
/*Output:
Modified array 
1 5 4 2 1 3 14 20 20 98 87 32 54 
*/  
        threeWayPartition(arr, 10, 20); 
   
        System.out.println("Modified array "); 
        for (int i=0; i < arr.length; i++) 
        { 
            System.out.print(arr[i] + " "); 
      
        }     
    }
    
/*A simple solution is to sort the array. 
This solution does a lot of extra rearrangements and requires O(n Log n) time.
An efficient solution is based on Dutch National Flag based QuickSort. 
We traverse given array elements from left. We keep track of two pointers, first (called start in below code) 
to store next position of smaller element (smaller than range) from beginning; 
and second (called end in below code) to store next position of greater element from end.*/


	private static void threeWayPartition(int[] arr, int a, int b) {
		int start = 0, end = arr.length-1;
		for( int i = 0; i <= end ; ) {
			if( arr[i] < a ) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				i++;
			} else if( arr[i] > b ) {
				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;
				
			} else {
				i++;
			}
		}
	}

}
