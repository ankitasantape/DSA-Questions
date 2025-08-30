package com.in28minutes.dsa_practice.dynamic_programming;

import java.util.Arrays;

public class A70_Climbing_Stairs {

    public int climbStairs_recursive(int n) {
        if(n < 0){
            return 0;
        }
        if(n <= 1){
            return 1;
        }
        return climbStairs_recursive(n-1) + climbStairs_recursive(n-2);
    }
    public int climbStairsMemo(int n, int[] memo){
        if(n < 0){
            return 0;
        }
        if(n <= 1){
            return 1;
        }

        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3; // output: 3

        // Brute Force
        A70_Climbing_Stairs climbingStairs = new A70_Climbing_Stairs();
        int ans = climbingStairs.climbStairs_recursive(n);
        System.out.println("Total number of ways: " + ans);
        // Memoize
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int ans2 = climbingStairs.climbStairsMemo(n, memo);
        System.out.println("Total number of ways: "+ ans2);
    }
}
