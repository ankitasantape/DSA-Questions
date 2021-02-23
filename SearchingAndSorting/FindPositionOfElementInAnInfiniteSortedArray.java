package Day8;
/*Find position of an element in a sorted array of infinite numbers
Difficulty Level : Medium
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.
*/
public class FindPositionOfElementInAnInfiniteSortedArray {
	
	public static int binarySearch(int arr[], int start, int end, int key) {
		while( start <= end ) {
			int mid = start + ( end - start )/2;
			if( arr[mid] == key ) {
				return mid;
			} else 
			if( arr[mid] > key ) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int findPos(int arr[],int key)  { 
        
          int start = 0, end = 1;
          while( key > arr[end] ) {
        	  start = end;
        	  end = 2 * end;
          }
          return binarySearch( arr, start, end , key);
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = findPos(arr, 10);

		if (ans == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index " + ans);
		}	
	}

}
