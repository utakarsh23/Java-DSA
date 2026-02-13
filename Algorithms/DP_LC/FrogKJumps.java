package DP_LC;

import java.util.*;

public class FrogKJumps {
    public static void main(String[] args) {
        System.out.println(new FrogKJumps().frogJumkK(new int[] {30, 10, 60, 10, 60, 50}, 3));
    }

    private int frogJumkK(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
//        return helperOne(arr, k, n-1);
//        return helperTwo(arr, dp, k, n-1);
//        return helperThree(arr, k);
//        return helperWithTabulation(arr, k);
        return helperWithTabulationLessSpace(arr, k);
    }

    //no dp
    private int helperOne(int[] arr, int k, int n) {
        if (n == 0) return 0;

        int steps = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n - i >= 0; i++) {
            steps = Math.min(steps, helperOne(arr, k, n - i) + Math.abs(arr[n] - arr[n - i]));
        }
        return steps;
    }

    //dp array
    private int helperTwo(int[] arr, int[] dp, int k, int n) {
        if (n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int steps = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n - i >= 0; i++) {
            steps = Math.min(steps, helperTwo(arr, dp, k, n - i) + Math.abs(arr[n] - arr[n - i]));
        }
        return dp[n] = steps;
    }

    //tabulation array
    private int helperThree(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                cost = Math.min(cost, dp[i-j] + Math.abs(arr[i] - arr[i-j]));
            }
            dp[i] = cost;
        }
        return dp[n-1];
    }

    //tabulation array
    private int helperWithTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int cost = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if(i - j >= 0) cost = Math.min(cost, dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                else break;
            }
            dp[i] = cost;
        }
        return dp[n-1];
    }

    private int helperWithTabulationLessSpace(int[] arr, int k) {
        LinkedList<Integer> dp = new LinkedList<>();
        int n = arr.length;
        dp.add(0);
        for (int i = 1; i < n; i++) {
            int cost = Integer.MAX_VALUE;
            int index = 1;
            for(int x : dp) {
                cost = Math.min(cost, x + Math.abs(arr[i] - arr[i - index++]));
                if(index > k) break;
            }
            dp.add(cost);
            if(dp.size() > k) {
                dp.removeFirst();
            }

        }
        return dp.getLast();
    }
}
