package com.in28minutes.dsa_practice.binary_search;

public class A704_Binary_Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return -1;
    }
}
