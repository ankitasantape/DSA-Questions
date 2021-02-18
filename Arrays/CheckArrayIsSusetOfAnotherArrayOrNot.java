package Day4;

import java.util.Arrays;

/*Array Subset of another array 
Easy Accuracy: 45.48% Submissions: 46658 Points: 2
Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n. Task is to check whether arr2[] is a subset of arr1[] or not. Both the arrays can be both unsorted or sorted. It may be assumed that elements in both array are distinct.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an two integers m and n denoting the size of arr1 and arr2 respectively. The following two lines contains the space separated elements of arr1 and arr2 respectively.

Output:
Print "Yes"(without quotes) if arr2 is subset of arr1.
Print "No"(without quotes) if arr2 is not subset of arr1.

Constraints:
1 <= T <= 100
1 <= m,n <= 105
1 <= arr1[i], arr2[j] <= 105

Example:
Input:
3
6 4
11 1 13 21 3 7
11 3 7 1
Output:
Yes arr2[] is subset of arr1[]

6 3
1 2 3 4 5 6
1 2 4
Output:
Yes arr2[] is subset of arr1[]

5 3
10 5 2 23 19
19 5 3
Output:
No arr2[] is not subset of arr1[]

Explanation:
Testcase 1: (11, 3, 7, 1) is a subset of first array.

*/
public class CheckArrayIsSusetOfAnotherArrayOrNot {
    /*Method 1 (Simple): 
      Use two loops: The outer loop picks all the elements of arr2[] one by one. 
      The inner loop linearly searches for the element picked by the outer loop. 
      If all elements are found then return 1, else return 0.
      Time Complexity: O(m*n) Space Complexity: O(1)            */
	static boolean isSubset(int arr1[], int arr2[], int m, int n) {
		int i = 0;
		int j = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (arr2[i] == arr1[j]) {
					break;
				}		
			}
			/*
			 * If the above inner loop was not broken at all then arr2[i] is not present in
			 * arr1[]
			 */
			if (j == m)
				return false;
		}

		/*
		 * If we reach here then all elements of arr2[] are present in arr1[]
		 */
		return true;
	}
/*Method 2 (Use Sorting and Binary Search):  
Sort arr1[] which takes O(mLogm)
For each element of arr2[], do binary search for it in sorted arr1[].
If the element is not found then return 0.
If all elements are present then return 1.*/
	public static boolean checkSubsetPresentOrNot(int arr1[], int arr2[], int m, int n) {
		int i = 0;
        Arrays.sort(arr1);
		for (i = 0; i < n; i++) {
			if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1)
				return false;
		}

		/*
		 * If we reach here then all elements of arr2[] are present in arr1[]
		 */
		return true;
	}

	/*
	 * FOLLOWING FUNCTIONS ARE ONLY FOR SEARCHING AND SORTING PURPOSE
	 */
	/* Standard Binary Search function */
	static int binarySearch(int arr[], int low, int high, int x) {
		if (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;

			/*
			 * Check if arr[mid] is the first occurrence of x. arr[mid] is first occurrence
			 * if x is one of the following is true: (i) mid == 0 and arr[mid] == x (ii)
			 * arr[mid-1] < x and arr[mid] == x
			 */
			if ((mid == 0 || x > arr[mid - 1]) && (arr[mid] == x))
				return mid;
			else if (x > arr[mid])
				return binarySearch(arr, (mid + 1), high, x);
			else
				return binarySearch(arr, low, (mid - 1), x);
		}
		return -1;
	}
/*Method 3 (Use Sorting and Merging ) 
Sort both arrays: arr1[] and arr2[] which takes O(mLogm + nLogn)
Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[].*/
	static boolean isSubset2(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;

		if (m < n)
			return false;

		Arrays.sort(arr1); // sorts arr1
		Arrays.sort(arr2); // sorts arr2

		while (i < n && j < m) {
			if (arr1[j] < arr2[i])
				j++;
			else if (arr1[j] == arr2[i]) {
				j++;
				i++;
			} else if (arr1[j] > arr2[i])
				return false;
		}

		if (i < n)
			return false;
		else
			return true;
	}
	public static void main(String[] args) {
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 3, 7, 1 };
 
        int m = arr1.length;
        int n = arr2.length;
 
        if (isSubset(arr1, arr2, m, n) && checkSubsetPresentOrNot(arr1, arr2, m, n) && isSubset2(arr1, arr2, m, n) )
            System.out.print("arr2[] is "
                             + "subset of arr1[] ");
        else
            System.out.print("arr2[] is "
                             + "not a subset of arr1[]");

	}

}
