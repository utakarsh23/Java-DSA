package DP_LC;

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        return helper(cost);
    }

    private int helper(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }

    private int helper1(int[] cost) {
        int n = cost.length;
        int prev = 0;
        int prev2 = 0;

        for(int i = 2; i <= n; i++) {
            int curr = Math.min(prev + cost[i-1], prev2 + cost[i-2]);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}