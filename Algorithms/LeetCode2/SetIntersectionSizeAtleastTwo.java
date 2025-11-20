package LeetCode2;

import java.util.Arrays;

public class SetIntersectionSizeAtleastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[1] == b[1])  return Integer.compare(b[0],a[0]);
            return Integer.compare(a[1],b[1]);
        });

        int prev2 = -1;
        int prev1 = -1;
        int count = 0;
        for(int[] range : intervals){
            int start = range[0];
            int end = range[1];

            if(start <= prev2){
                continue;

            }else if(start <= prev1){

                count+=1;
                prev2 = prev1;
                prev1 = end;

            }else {
                count+=2;
                prev2 = end - 1;
                prev1 = end;

            }
        }

        return count;
    }
}
