package DP_LC;

import java.util.Arrays;


public class FrogJump {
    public static void main(String[] args) {
        System.out.println(frogJumpSpace(new int[] {30, 10, 60, 10, 60, 50}));
    }

    //no dp
    public static int frogJump(int[] arr) {
        int n = arr.length-1;
        return frogJumpHelper(n, arr);
    }

    public static int frogJumpHelper(int n, int[] arr) {
        if(n == 0) return 0;
        int oneStep = frogJumpHelper(n-1, arr) + Math.abs(arr[n] - arr[n-1]);
        int twoStep = Integer.MAX_VALUE;
        if(n > 1) twoStep = frogJumpHelper(n-2, arr) + Math.abs(arr[n] - arr[n-2]);
        return Math.min(oneStep, twoStep);
    }

    //with dp
    public static int frogJump1(int[] arr) {
        int n = arr.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return frogJump1Helper(n, arr, dp);
    }

    public static int frogJump1Helper(int n, int[] arr, int[] dp) {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int oneStep = frogJump1Helper(n-1, arr, dp) + Math.abs(arr[n] - arr[n-1]);
        int twoStep = Integer.MAX_VALUE;
        if(n > 1) twoStep = frogJump1Helper(n-2, arr, dp) + Math.abs(arr[n] - arr[n-2]);
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }

    //tabulation dp array
    public static int frogJumpT(int[] arr) {
        int n = arr.length-1;
        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(
                    dp[i-1] + Math.abs(arr[i] - arr[i-1]),
                    dp[i-2] + Math.abs(arr[i] - arr[i-2])
            );
        }
        return dp[n];
    }

    //tabulation dp, no array
    public static int frogJumpSpace(int[] arr) {
        int n = arr.length-1;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
        int prev = 0; //two steps, (0th index)
        int prev2 = 0; //one step
        int curr = 0;
        for (int i = 1; i <= n; i++) {
            int stepOne = prev + Math.abs(arr[i] - arr[i-1]);
            int stepTwo = Integer.MAX_VALUE;
            if(i > 1) stepTwo = prev2 + Math.abs(arr[i] - arr[i-2]);
            curr = Math.min(
                    stepOne, stepTwo
            );
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    ///
    public static int frogJumpSpace1(int[] arr) {
        int n = arr.length-1;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
        int one = Math.abs(arr[1] - arr[0]); //two steps, (0th index)
        int two  = Math.abs(arr[2] - arr[0]);; //one step
        for (int i = 3; i <= n; i++) {
            int temp = two;
            int stepOne = one + Math.abs(arr[i] - arr[i-1]);
            int stepTwo = two + Math.abs(arr[i] - arr[i-2]);
            two = Math.min(
                    stepOne, stepTwo
            );
            one = temp;
        }
        return two;
    }
}


