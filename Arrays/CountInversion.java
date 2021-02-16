package Day2;

import java.util.Scanner;

/*Count Inversions 
Easy Accuracy: 39.43% Submissions: 28616 Points: 2
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(nLogn).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ C ≤ 1018
*/
public class CountInversion {
   public static int mergeSort(int[] input){
	    int temp[] = new int[input.length];
		int count = mergeSort(input,temp ,0, input.length - 1);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		System.out.print("Number of Inversion : ");
		return count;
	}
	private static int mergeSort(int []input,int[] temp, int si, int ei) {

        int inv_count = 0, mid ;
		if (si < ei) {
			mid = (si + ei) / 2;
			inv_count += mergeSort(input,temp, si, mid);
			inv_count += mergeSort(input,temp, mid + 1, ei);
			inv_count += merge(input,temp, si, mid + 1, ei);
		}
		return inv_count;
	}
	
	private static int merge(int[] input,int[] temp,int si,int mid, int ei) {
		int inv_count = 0;
		int i, j, k;
		i = si; 
		j = mid; 
		k = si ; // Why k = left? You can keep it as 0 also, it is for merging it to temp array 
		
		while((i <= mid -1 ) && ( j <= ei )) {
			if( input[i] <= input[j] ) {
				temp[k++] = input[i++];
			}else {
				temp[k++] = input[j++];
//we will take all elements from i to mid becoz that will form the pairs with the curr one we will count all the element to the right 
				inv_count += (mid - i); 
			}
		}
		
		while( i <= mid - 1) {
			temp[k++] = input[i++];
		}
		while( j <= ei ) {
			temp[k++] = input[j++];
		}
		for( i = si; i <= ei; i++ ) {
			input[i] = temp[i];
		}
		return inv_count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for( int i = 0 ; i < n; i++ ) {
			a[i] = sc.nextInt();
		}
        System.out.println(mergeSort(a));
        sc.close();
	}

}
