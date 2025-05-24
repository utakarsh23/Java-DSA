package LeetCode;

import java.util.Arrays;

public class CountPaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }

    //using dp
    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countPaths(m, n, dp);
    }
    static int countPaths(int row, int col, int[][] dp) {
        if(row == 1 || col == 1) {
            return 1;
        }
        if(dp[row][col] != -1) return dp[row][col];
        int left = countPaths(row-1, col, dp);
        int right = countPaths(row, col-1, dp);

        return dp[row][col] = left + right;
    }


    /// m2
    //using backtracking
    static int countPaths(int row, int col) {
        if(row == 1 || col == 1) {
            return 1;
        }
        int left = countPaths(row-1, col);
        int right = countPaths(row, col-1);

        return left + right;
    }
}
