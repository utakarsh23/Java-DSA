package LeetCode2;

import java.util.List;

public class PathsInMatrixWhoseSumDivisibleByK {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(new int[][] {{7,3,4,9},{2,3,6,2},{2,3,7,0}}, 1));
    }

    private static Integer[][][] dp;
    static int mod = 1_000_000_007;

    static public int numberOfPaths(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k];
        int c = helperFunc(grid, grid[0][0] % k, 0, 0, k);
        return c % mod;
    }

    private static int helperFunc(int[][] grid, int sumMod, int i, int j, int k) {
        int len = grid.length-1;
        int colLen = grid[0].length-1;

        if(i == len && j == colLen) {
            return sumMod%k == 0 ? 1 : 0;
        }

        if(dp[i][j][sumMod] != null) {
            return dp[i][j][sumMod];
        }

        long ans = 0;

        if(j < colLen) ans += helperFunc(grid, (sumMod + grid[i][j+1]) % k, i, j+1, k);
        if(i < len) ans += helperFunc(grid, (sumMod + grid[i+1][j]) % k, i+1, j, k);

        return dp[i][j][sumMod] = (int)(ans % mod);
    }
}
