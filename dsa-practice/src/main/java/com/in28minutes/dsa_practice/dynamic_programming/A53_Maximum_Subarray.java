package com.in28minutes.dsa_practice.dynamic_programming;

public class A53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int prevsum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            prevsum = Math.max(nums[i], prevsum + nums[i]);
            maxSum = Math.max(prevsum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // output: 6
        A53_Maximum_Subarray maximumSubarray = new A53_Maximum_Subarray();
        System.out.println("Maximum sum : " + maximumSubarray.maxSubArray(nums));
    }
}
