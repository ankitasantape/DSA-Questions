package Day10;
/*In-Place Merge Sort
Difficulty Level : Hard
Implement Merge Sort i.e. standard implementation keeping the sorting algorithm as in-place. 
In-place means it does not occupy extra memory for merge operation as in standard case.
Examples: 
Input: arr[] = {2, 3, 4, 1} 
Output: 1 2 3 4

Input: arr[] = {56, 2, 45} 
Output: 2 45 56 

Approach : 
Maintain two pointers which point to start of the segments which have to be merged.
Compare the elements at which the pointers are present.
If element1 < element2 then element1 is at right position, simply increase pointer1.
Else shift all the elements between element1 and element2(including element1 but excluding element2) 
right by 1 and then place the element2 in the previous place(i.e. before shifting right) of element1. 
Increment all the pointers by 1.
Note : Time Complexity of above approach is O(n2) because merge is O(n2). 
       Time complexity of standard merge sort is less, O(n Log n).
*/
public class InplaceMergeSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
        mergeSort(arr,0,n-1);
        print(arr,n);
	}

	private static void print(int[] arr, int n) {
		for( int i = 0; i < n; i++ ) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if( start < end ) {
			int mid = start + (end - start)/2;
			mergeSort( arr, start, mid );
			mergeSort( arr, mid+1, end );
			merge( arr, start, mid, end );
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int start2 = mid+1;
		if( arr[mid] <= arr[start2]) {
			return;
		}
		
		while( start <= mid && start2 <= end ) {
			// if first element is at right place
			if( arr[start] < arr[start2] ) {
				start++;
			}else {
				
				// first store element at index start2 into value variable 
				int value = arr[start2];
				int index = start2;
				
				// Shift all the elements between element 1 to element 2, right by 1.
				while( index != start ) {
					arr[index] = arr[index-1];
					index--;
				}
				// finally, store the prev value at index start2 into curr position
				arr[start] = value;
				
				//Update all pointers
				start++;
				mid++;
				start2++;
			}
		}
	}

}
