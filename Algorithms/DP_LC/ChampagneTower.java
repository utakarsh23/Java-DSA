package DP_LC;

import java.util.Arrays;

class ChampagneTower
 {
    public double champagneTower(int poured, int i, int j) {
        double[][] dp = new double[i+1][j+1];
        for (double[] r : dp) {
            Arrays.fill(r, -1.0);
        }
        return Math.min(1.0, helper(poured, i, j, dp));
    }

    private double helper(double p, int i, int j, double[][] dp) {
        // System.out.println(p);
        if(j < 0 || j > i) return 0.0;
        if(i == 0 && j == 0) return p;
        if(dp[i][j] != -1) return dp[i][j];
        double left = helper(p, i - 1, j - 1, dp);
        double right = helper(p, i - 1, j, dp);
        return dp[i][j] = (Math.max(0, left - 1) / 2.0 + Math.max(0, right - 1) / 2.0);
    }
}