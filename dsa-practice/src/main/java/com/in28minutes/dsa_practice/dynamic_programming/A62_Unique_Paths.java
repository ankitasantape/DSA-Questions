package com.in28minutes.dsa_practice.dynamic_programming;

import java.util.Arrays;

public class A62_Unique_Paths {

    private int uniquePathsRec(int m, int n, int[][] memo){
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(memo[m][n] != -1){
            return memo[m][n];
        }

        memo[m][n] = uniquePathsRec(m-1, n, memo) + uniquePathsRec(m, n-1, memo);
        return memo[m][n];
    }

    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int j = 1; j < n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        A62_Unique_Paths uniquePaths = new A62_Unique_Paths();
        int m = 3;
        int n = 7;
        int[][] memo = new int[m][n];
        for(int[] num : memo){
            Arrays.fill(num, -1);
        }
        int ans = uniquePaths.uniquePathsRec(m-1,n-1, memo);
        System.out.println("Total unique path: " + ans);

        int ans2 = uniquePaths.uniquePathsDP(m, n);
        System.out.println("Total unique path: " + ans2);
    }
}
