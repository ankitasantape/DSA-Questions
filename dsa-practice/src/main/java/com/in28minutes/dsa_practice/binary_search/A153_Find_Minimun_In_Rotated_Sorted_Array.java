package com.in28minutes.dsa_practice.binary_search;

public class A153_Find_Minimun_In_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid + 1; // minimum is in right half
            }
            else {
                right = mid; // minimum is in left half or on mid itself
            }
        }

        return nums[left];
    }
}
