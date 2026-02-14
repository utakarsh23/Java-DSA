package DP_LC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UniquePathsIII {

    public static void main(String[] args) {
//        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0}, {0, 1}}));
//        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0}, {0, 1}}));
//        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 1, 0}}));
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][] {{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }

    class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return a == p.a && b == p.b;
        }

        @Override
        public int hashCode() {
            return 31 * Integer.hashCode(a) + Integer.hashCode(b);
        }
    }


    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] r : dp) {
            Arrays.fill(r, -1);
        }
        Set<Pair> tracked = new HashSet<>();
        int i = 0, j = 0;
        int p = 0, q = 0;
        int k = 0, l = 0;
        for(; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    p = i;
                    q = j;
                }
                if(grid[i][j] == 1) {
                    k = i;
                    l = j;
                }
            }
        }
        return helper(grid, p, q, dp, tracked, k, l);
    }

    private int helper(int[][] grid, int m, int n, int[][] dp, Set<Pair> tracked, int k, int l) {
        if(m <= 0 || n <= 0 || m >= grid.length-1 || n >= grid[0].length-1) return 0;
        if(grid[m][n] == -1) return 0;
        if(m == k && n == l) return 1;
        if(dp[m][n] != -1) return dp[m][n];

        Pair key = new Pair(m, n);
        int left = 0, right = 0, up = 0, down = 0;
        if(!tracked.contains(key)) {
            tracked.add(key);
            if(grid[m-1][n] != -1) {
                left = helper(grid, m-1, n, dp, tracked, k, l);
            }
            if(grid[m+1][n] != -1) {
                right = helper(grid, m+1, n, dp, tracked, k, l);
            }
            if(grid[m][n-1] != -1) {
                up = helper(grid, m, n-1, dp, tracked, k, l);
            }
            if(grid[m][n+1] != -1) {
                down = helper(grid, m, n+1, dp, tracked, k, l);
            }
            tracked.remove(key);
        }
        return dp[m][n] = left + right + up + down;

    }
}