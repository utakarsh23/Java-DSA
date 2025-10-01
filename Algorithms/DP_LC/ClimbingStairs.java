package DP_LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }

    //no dp
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int one = climbStairs(n-1);
        int two = climbStairs(n-2);
        return one + two;
    }

    //with dp
    public static int climbStairs1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n, dp);
    }

    public static int climbStairsHelper(int n, int[] dp) {
        if(n <= 1) return 1;

        if (dp[n] != -1) return dp[n];   // check cache for n
        int one = climbStairsHelper(n-1, dp);
        int two = climbStairsHelper(n - 2, dp);
        dp[n] = one+two;
        return one + two;
    }}


