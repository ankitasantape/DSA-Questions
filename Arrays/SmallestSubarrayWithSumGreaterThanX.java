package Day5;
/*Smallest subarray with sum greater than x 
Easy Accuracy: 47.04% Submissions: 2873 Points: 2
Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
Example 1:
Input:
A[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Explanation:
Minimum length subarray is 
{4, 45, 6}

Example 2:
Input:
A[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Explanation:
Minimum length subarray is {10}

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N, x ≤ 105
1 ≤ A[] ≤ 104
*/
public class SmallestSubarrayWithSumGreaterThanX {
//	Time Complexity: Time complexity of the below approach is clearly O(n2).
	public static int smallestSubWithSum(int arr[], int n, int x)
    {
        //  Initilize length of smallest subarray as n+1
        int min_len = n + 1;
 
        // Pick every element as starting point
        for (int start = 0; start < n; start++)
        {
            // Initialize sum starting with current start
            int curr_sum = arr[start];
 
            // If first element itself is greater
            if (curr_sum > x)
                return 1;
 
            // Try different ending points for curremt start
            for (int end = start + 1; end < n; end++)
            {
                // add last element to current sum
                curr_sum += arr[end];
 
                // If sum becomes more than x and length of
                // this subarray is smaller than current smallest
                // length, update the smallest length (or result)
                if (curr_sum > x && (end - start + 1) < min_len)
                    min_len = (end - start + 1);
            }
        }
        return min_len;
    }
	
	public static int smallestSubWithSum2(int arr[], int n, int x)
    {
		int start = 0, end = 0, minLen = Integer.MAX_VALUE, currSum = 0;
		while( end < n ) {
			while( currSum <= x && end < n ) {
				currSum += arr[end];
				end++;
			}
			System.out.print(currSum + " " + end);
			System.out.println();
			while( currSum > x && start < n ) {
				if( end - start < minLen ) {
					minLen = end - start;
				}
				currSum -= arr[start];
				System.out.println(currSum + " " + minLen);
				start++;
			}
		}
		return minLen;
    }
	
	public static void main(String[] args) {
//		int arr1[] = {1, 4, 45, 6, 10, 19};
//        int x = 51;
//        int n1 = arr1.length;
//        int res1 = smallestSubWithSum(arr1, n1, x);
//        if (res1 == n1+1)
//           System.out.println("Not Possible");
//        else
//           System.out.println(res1);
//       
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum2(arr1, n1, x);
        if (res1 == n1+1)
           System.out.println("Not Possible");
        else
           System.out.println(res1);
 
 
//        int arr2[] = {1, 10, 5, 2, 7};
//        int n2 = arr2.length;
//        x = 9;
//        int res2 = smallestSubWithSum(arr2, n2, x);
//        if (res2 == n2+1)
//           System.out.println("Not Possible");
//        else
//           System.out.println(res2);
// 
//        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
//        int n3 = arr3.length;
//        x = 280;
//        int res3 = smallestSubWithSum(arr3, n3, x);
//        if (res3 == n3+1)
//           System.out.println("Not Possible");
//        else
//           System.out.println(res3);
        
        /*  Output : 3
         *           1
         *           4
         * */
    }
}
