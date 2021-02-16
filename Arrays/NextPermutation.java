31. Next Permutation
Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 
Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

1. Brute force: We find out every possible permutation of list formed by the elements of the given array and find out the permutation which is just larger than given one.
Time Complexity : O(n!) , Space Complexity : O(n)

2. One pass / two pointer solution: 1st ptr x to first decreasing number, if( x < 0 ), all elements are in decreasing order, so reverse ans return 2nd ptr to last/just greater than
smallest element found swap
1. Find the highest index i such that s[i] < s[i+1]. If no such index exists, then this permutation is the last permutation
2. Find the highest index j > i such that s[j] > s[i] such a j must exist, since i+1 is such an index.
3. Swap s[i] with s[j]
4. Reverse the order of all of the elements after index i till the last element. 
Time Complexity : O(n)  , Auxiliary Space : O(1)

class Solution {
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse( int nums[], int low ){
        int high = nums.length - 1;
        while( low < high ){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while( i >= 0 && nums[i] >= nums[i+1] ){
            i-- ;
        }
        if( i >= 0 ){
            int j = nums.length - 1;
            while( j >= 0 && nums[j] <= nums[i] ){
                j--;
            }
            swap( nums, i, j );
        } 
        reverse( nums, i+1 );
    }
}
