package Day4;

import java.util.Scanner;

/*Trapping Rain Water 
Medium Accuracy: 49.62% Submissions: 32501 Points: 4
Given an array arr[] of N non-negative integers representing the height of blocks. 
If width of each block is 1, compute how much water can be trapped between the blocks during the rainy 
season. 
Example 1:
Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
3 <= N <= 107
0 <= Ai <= 108*/
public class TrappingRainWater {
    public static int trappingWater(int arr[], int n) {
		int mxl[] = new int[n];
		int mxr[] = new int[n];
		mxl[0] = arr[0];
		for( int i = 1; i < n; i++ ) {
			mxl[i] = Math.max( mxl[i-1], arr[i]);
		}
//		for( int i : mxl ) {
//        	System.out.print(i + " ");
//        }
//		System.out.println();
		mxr[n-1] = arr[n-1];
		for( int i = n-2; i >= 0; i-- ) {
			mxr[i] = Math.max( mxr[i+1], arr[i]);
		}
//		for( int i : mxr ) {
//        	System.out.print(i + " ");
//        }
//		System.out.println();
        int water[] = new int[n];
        for( int i = 0; i < n; i++ ) {
        	water[i] = Math.min( mxl[i], mxr[i]) - arr[i];
        }
//        for( int i : water ) {
//        	System.out.print(i + " ");
//        }
        int sum = 0;
        for( int i = 0; i < n; i++ ) {
        	sum += water[i];
        }
        return sum;
    } 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for( int i = 0; i < n; i++ ) {
        	a[i] = s.nextInt();
        }
        System.out.println(trappingWater(a,n));
        s.close();
	}

}
