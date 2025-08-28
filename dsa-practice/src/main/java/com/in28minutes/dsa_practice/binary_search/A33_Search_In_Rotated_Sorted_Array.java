package com.in28minutes.dsa_practice.binary_search;

public class A33_Search_In_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                // Target is in left side
                if( nums[low] <= target && target < nums[mid] ){
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[high] ){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
