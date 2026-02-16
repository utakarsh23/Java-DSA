package DP_LC;

class MinPathSum {

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
    }
    int ans = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        return helper(grid, grid.length-1, grid[0].length-1, 0);
    }

    private int helper(int[][] grid, int m, int n, int sum) {
        if(m == 0 && n == 0) return sum += grid[m][n];
        if(m < 0 || n < 0) return 0;
        int up = 0, left = 0;
        if(m - 1 >= 0) up = helper(grid, m - 1, n, sum + grid[m][n]);
        if(n - 1 >= 0) left = helper(grid, m, n - 1, sum + grid[m][n]);
        return ans = Math.min(ans, up + left);
    }

    public int helperTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
