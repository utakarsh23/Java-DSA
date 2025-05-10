package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {

    }
    int countPairs(int[] arr, int target) {
        // Your code here
        int count = 0;
        Arrays.sort(arr);
        Map<Integer, Integer> set = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int col = target - arr[i];
            if(set.containsKey(col)) {
                count+=set.get(col);
            }
            set.put(arr[i], set.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
