package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class mergeOverlap {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(new mergeOverlap().merge1(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})));
        System.out.println(Arrays.deepToString(new mergeOverlap().merge1(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length == 0) return new int[0][];
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = arr[0];
        merged.add(current);
        
        for (int i = 1; i < arr.length; i++) {
            int[] next = arr[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);  // merge
            } else {
                current = next;
                merged.add(current);  // start new interval
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }


//    public int[][] merge1(int[][] arr) {
//        if (arr == null || arr.length == 0) return new int[0][];
//
//        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
//        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        List<int[]> list = new ArrayList<>();
//        int n = arr.length;
//        for(int i = 1; i <= n; i++) {
//            int ms = arr[i-1][0];
//            int s = ms;
//            int me = arr[i-1][1];
//            while(i < n && s <= arr[i-1][1]) {
//                i++;
//                me = Math.max(me, arr[i-1][1]);
//                ms = Math.min(ms, arr[i-1][0]);
//
//            }
//            list.add(new int[] {ms, me});
//        }
//        int[][] ans = new int[list.size()][2];
//        int i = 0;
//        for (int[] x : list) {
//            ans[i++] = x;
//        }
//        return ans;
//    }

    public int[][] merge1(int[][] arr) {
        if (arr == null || arr.length == 0)
            return new int[0][];

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; ) {
            int ms = arr[i][0];
            int me = arr[i][1];

            // merge all intervals that overlap with current
            int j = i + 1;
            while (j < n && arr[j][0] <= me) {
                me = Math.max(me, arr[j][1]);
                j++;
            }

            list.add(new int[]{ms, me});
            i = j;
        }

        return list.toArray(new int[list.size()][]);
    }
}