package LeetCode2;

import java.util.Arrays;

class MinimumOperationstoEqualizeSubarrays {
    public long[] minOperations(int[] nums, int k, int[][] queries) {

        long[] arr = new long[queries.length];
        int i = 0;
        for (int[] x : queries) {
            arr[i++] = isPossible(Arrays.copyOfRange(nums, x[0], x[1] + 1), k);
        }
        return arr;
    }

    private long isPossible(int[] arr, int k) {
        int n = arr.length;
        int te;
        Arrays.sort(arr);
        if (n % 2 == 0) {
            int mid = n / 2;
            te = arr[n - 1] - arr[mid - 1] > arr[0] - arr[mid] ? arr[mid] : arr[mid - 1];
        } else {
            te = arr[n / 2];
        }
        long ans = 0;
        boolean changed = false;
        for (int x : arr) {
            if ((x - te) % k != 0)
                return -1;
            int t = Math.abs(x - te) / k;
            ans += t;
        }
        return ans;
    }

    // 1 4 7 10
    //
    // 0 4 8 12 16 : k = 2;
    // 4 2 0  2  4  
    // 
}