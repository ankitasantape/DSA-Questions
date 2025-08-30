package com.in28minutes.dsa_practice.dynamic_programming;

public class A198_House_Robber {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        int curr = 0;
        for(int i = 2; i < n; i++){
            curr = Math.max(prev1 + nums[i] , prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return Math.max(prev1, prev2);
    }

    public static void main(String[] args) {
        A198_House_Robber houseRobber = new A198_House_Robber();
        int[] nums = {2,7,9,3,1};
        int maxCost = houseRobber.rob(nums);
        System.out.println("Maximum amount robber could robbed: " + maxCost);
    }
}
