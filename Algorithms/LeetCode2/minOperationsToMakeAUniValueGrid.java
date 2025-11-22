package LeetCode2;

import java.util.Arrays;

public class minOperationsToMakeAUniValueGrid {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{1,1,10000}}, 1));
    }


    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return 0;
        int k = 0;
        int[] arr = new int[m*n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int tme;
        int mid = n*m/2;
        if(n * m % 2 == 0) {
            int me = arr[mid];
            int bme = arr[mid-1];
            if(arr[n*m-1] - bme > me - arr[0]) tme = me;
            else tme = bme;
        } else {
            tme = arr[mid];
        }

        int ans = 0;
        for(int y : arr) {
            int t = Math.abs(y - tme);
            if(t%x != 0) return -1;
            ans += t/x;
        }
        // if(((me % 2 != 0 && bme%2 == 0) || (me % 2 == 0 && bme%2 != 0)) && x%2 == 0) return -1;
        return ans;
    }
}
