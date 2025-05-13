package LeetCode;

public class EqualSumGridPortionI {
    public static void main(String[] args) {
        System.out.println(canPartitionGrid(new int[][]{{65917,79299}}));
    }
    static boolean canPartitionGrid(int[][] grid) {
        //rows
//        int sum = 0;
//        int tempChk = 0;
//        int temp;
//        int j = 0;
//        for(int[] arr : grid) {
//            temp = sum;
//            if(sum != tempChk * temp) break;
//            sum += rows(arr);
//            tempChk++;
//            if(j++ == grid.length -1) return true;
//        }
//        if(sum == rows(grid[0]) * grid[0].length) return true;
//
//        sum = 0;
//        tempChk = 0;
//        for(int i = 0; i < grid[0].length; i++) {
//            temp = sum;
//            if(sum != tempChk * temp) break;
//            sum += cols(grid, i);
//            tempChk++;
//        }
//        return sum == cols(grid, 0) * grid.length;
        long sum = 0;
        int j = 0;
        for(int[] arr : grid) {
            sum += rows(arr);
            if(j == grid.length - 1 && sum == (long) rows(arr) * grid.length) return true;
            j++;
        }

        sum = 0;
        j = 0;
        for(int i = 0; i < grid[0].length; i++) {
            sum += cols(grid, i);
            if(j == grid[0].length && sum == (long) cols(grid, 0) * grid[0].length) return true;
            j++;
        }
        return false;
    }
    static int rows(int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        return sum;
    }
    static int cols(int[][] arr, int c) {
        int sum = 0;
        for (int[] ints : arr) {
            sum += ints[c];
        }
        return sum;
    }

    //m2
    static public boolean canPartitionGrid1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long totalRowSum = 0L, totalColSum = 0L;
        long[] prefixRowWise = new long[n];
        long[] prefixColWise = new long[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                long vl = v;
                prefixRowWise[i] += vl;
                prefixColWise[j] += vl;
            }
        }

        for (long r : prefixRowWise) totalRowSum += r;
        totalColSum = totalRowSum;

        long currentRowUpperSum = 0L;
        for (int i = 0; i < n - 1; i++) {
            currentRowUpperSum += prefixRowWise[i];
            long lowerSegmentSum = totalRowSum - currentRowUpperSum;
            if (currentRowUpperSum == lowerSegmentSum) return true;
        }

        long currentColLeftSum = 0L;
        for (int j = 0; j < m - 1; j++) {
            currentColLeftSum += prefixColWise[j];
            long rightSegmentSum = totalColSum - currentColLeftSum;
            if (currentColLeftSum == rightSegmentSum) return true;
        }
        return false;
    }
}
