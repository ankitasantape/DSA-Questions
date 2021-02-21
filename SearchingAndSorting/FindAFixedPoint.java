package Day7;

import java.util.Scanner;

/*Value equal to index value 
School Accuracy: 64.27% Submissions: 7271 Points: 0
Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of 

its index value.
Example 1:
Input: 
N = 5
Arr[] = {15, 2, 45, 12, 7}
Output: 2
Explanation: Only Arr[2] = 2 exists here.

Example 2:
Input: 
N = 1
Arr[] = {1}
Output: 1
Explanation: Here Arr[1] = 1 exists.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function valueEqualToIndex() which takes the array of integers arr[] and n as parameters and returns an array of indices where the given conditions are satified. When there is not such element exists then return an empty array of length 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Note: There can be more than one element in the array which have same value as their index. You need to include every such element's index. Follows 1-based indexing of the array.

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
*/
public class FindAFixedPoint {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++ ) {
        	a[i] = s.nextInt();
        }
        
        for( int i = 0; i < n; i++ ) {
        	if( a[i] == i+1 ) {
        		System.out.println(a[i]);
        	}
        }
        s.close();
	}

}
