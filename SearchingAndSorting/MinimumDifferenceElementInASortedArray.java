package Day8;
/*Find minimum difference between any two elements
Difficulty Level : Basic
Given an unsorted array, find the minimum difference between any pair in given array.

Examples :
Input  : {1, 5, 3, 19, 18, 25};
Output : 1
Minimum difference is between 18 and 19

Input  : {30, 5, 20, 9};
Output : 4
Minimum difference is between 5 and 9

Input  : {1, 19, -4, 31, 38, 25, 100};
Output : 5
Minimum difference is between 1 and -4
*/
public class MinimumDifferenceElementInASortedArray {
    
	public static void main(String[] args) {
		int arr[] = {1, 19, -4, 31, 38, 25, 100};
		int key = 7;
		System.out.println("Minimum Difference Element : "+findMinDiff(arr,arr.length, key));

	}
	private static int findMinDiff(int[] arr, int length, int key) {
		int start = 0, end = length - 1;
		while( start <= end ) {
			int mid = start + ( end - start )/ 2;
			if( key == arr[mid] ) {
				return arr[mid];
			}else if( key < arr[mid] ) {
				end = mid - 1 ;
			}else {
			    start = mid + 1;	
			}
		}
		int index = Math.abs(arr[start] - key) < Math.abs(arr[end] - key) ? start : end;
		return arr[index];
	}

}

/* Output : Minimum Difference Element : 1  */
