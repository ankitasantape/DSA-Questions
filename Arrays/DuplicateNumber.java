Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

Using Tortoise Method
Time Complexity - O(n)
Auxiliary Space - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while( slow != fast );
	    fast = nums[0];
        while( slow != fast ){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

Time Complexity - O(n*n)
Auxiliary Space - O(1)
public static int duplicateNumber(int arr[]) {
       int res = 0, n = arr.length;
	   for(int i = 0; i < n; i++)
	   {
		  for(int j = i + 1; j < n; j++)
		  {
			  if( (arr[i] == arr[j] && (i != j)))
			  {
				  res = arr[j];
			  }
		  }
		 
	   }
	   return res;
	}
