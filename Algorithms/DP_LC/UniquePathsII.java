package DP_LC;

import java.util.Arrays;

class UniquePathsII {

    public static void main(String[] args) {
//        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0}, {0, 1}}));
//        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0}, {0, 1}}));
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 1, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return helper(m-1, n-1, dp, obstacleGrid);
    }

    private int helper(int m, int n, int[][] dp, int[][] grid) {
        if(dp[m][n] != -1) return dp[m][n];
        if(m == 0 || n == 0) return 1;

        int left = 0, right = 0;
        if(grid[m-1][n] != 1) left = helper(m-1, n, dp, grid);
        if(grid[m][n-1] != 1) right = helper(m, n-1, dp, grid);
        return dp[m][n] = grid[m][n] != 1 ? left + right : 0;
    }

}