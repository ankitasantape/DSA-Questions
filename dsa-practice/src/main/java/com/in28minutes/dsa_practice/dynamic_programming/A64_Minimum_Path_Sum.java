package com.in28minutes.dsa_practice.dynamic_programming;

public class A64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // DP table to store minimum path sums
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // Fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        A64_Minimum_Path_Sum minimumPathSum = new A64_Minimum_Path_Sum();
        int[][] grid = {
            {1,3,1},{1,5,1},{4,2,1}
        }; // output: 7
        int minPath = minimumPathSum.minPathSum(grid);
        System.out.println("Minimum path: " + minPath);
    }
}
