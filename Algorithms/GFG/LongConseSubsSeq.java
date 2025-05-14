package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class LongConseSubsSeq {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {99, 80, 60, 33, 44, 86, 34, 64, 77, 18, 39, 3, 27, 16, 29, 60, 67, 23, 7, 87, 6 ,75, 92, 11, 59, 13, 88, 24, 98, 4, 26, 6}));
    }
    static int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> li = new ArrayList<>();
        int max = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] + 1 == arr[i] || arr[i-1] == arr[i]) {
                max++;
            } else {
                li.add(max);
                max = 1;
            }
        }
        li.add(max);
        for (int x : li) max = Math.max(max, x);
        return max;
    }
}
