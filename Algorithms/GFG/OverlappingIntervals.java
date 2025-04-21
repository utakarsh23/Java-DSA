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

}
