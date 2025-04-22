package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class mergeOverlap {
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
}