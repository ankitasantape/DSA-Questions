package Day8;
/*Find the index of first 1 in an infinite sorted array of 0s and 1s
Difficulty Level : Medium

Approach: The problem is closely related to the problem of finding position of an element in a sorted array of 
infinite numbers. As the array is infinte, therefore we do not know the upper and lower bounds between which we 
have to find the occurrence of first ‘1’. Below is an algorithm to find the upper and lower bounds.
Algorithm:

posOfFirstOne(arr)
    Declare l = 0, h = 1
    while arr[h] == 0
        l = h
    h = 2*h;
    return indexOfFirstOne(arr, l, h)
}
Here h and l are the required upper and lower bounds. indexOfFirstOne(arr, l, h) is used to find the index of 
occurrence of first ‘1’ between these two bounds

Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first ‘1’ in that array. As the array is infinite, therefore it is guaranteed that number ‘1’ will be present in the array.
Examples:
Input : arr[] = {0, 0, 1, 1, 1, 1} 
Output : 2

Input : arr[] = {1, 1, 1, 1, 1, 1, 1}
Output : 0

Let p be the position of element to be searched. Number of steps for finding high index ‘h’ is O(Log p). 
The value of ‘h’ must be less than 2*p. The number of elements between h/2 and h must be O(p). 
Therefore, time complexity of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log p) 
which is O(Log p).
*/
public class FindFirstOneIndexInInfiniteArray {

	public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 1, 1};
        System.out.println( findIndex(arr,arr.length));

	}

	private static int findIndex(int[] arr, int length) {
		int start = 0, end = 1, key = 1;
		while( key > arr[end] ) {
			start = end;
			end = end * 2;
		}
		return first( arr, length, start, end, 1);
	}
    
	/* Time Complexity- O( log n ) Space Complexity - O(1)   */
    public static int first(int a[], int n,int start, int end, int x) {
//           int start= 0, end = n-1;
           int res = -1; 
           while( start <= end ) {
        	   int mid =start + (end-start)/2; 
        	   if(x == a[mid]) {
        		   res = mid;
        		   end = mid - 1;
        	   } else if( x < a[mid] ) {
        		   end = mid - 1;
        	   } else {
        		   start = mid +1;
        	   }
           }
           return res;
    }
}
