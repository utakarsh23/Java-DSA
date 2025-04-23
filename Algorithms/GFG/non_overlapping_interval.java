package GFG;

import java.util.Arrays;
import java.util.Comparator;

public class non_overlapping_interval {
    static int minRemoval(int intervals[][]) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count =1;
        int lastEndTime = intervals[0][1];
        for(int i =1; i < intervals.length; i++) {
            if(intervals[i][0] >= lastEndTime) {
                count ++;
                lastEndTime = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
