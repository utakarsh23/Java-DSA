package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {
    public static void main(String[] args) {

    }
    public List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(!res.isEmpty() && res.get(res.size() - 1)[1] >= end) {
                continue;
            }

            for(int j = i + 1; j < n; j++) {
                if(arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
            }
            res.add(new int[]{start, end});
        }
        return res;
    }
    public List<int[]> mergeOverlap1(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {arr[0][0], arr[0][1]});




        for(int i = 1; i < n; i++) {
            int last[] =res.get(res.size() - 1);
            int curr[] = arr[i];
            if(curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.add(new int[] {curr[0], curr[1]});
            }
        }
        return res;
    }
}
