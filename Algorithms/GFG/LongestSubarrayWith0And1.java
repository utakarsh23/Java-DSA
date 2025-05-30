package GFG;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith0And1 {
    public static void main(String[] args) {

    }
    public int maxLen(int[] arr) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                preSum += -1;
            } else {
                preSum += 1;
            }
            if(preSum == 0) {
                res = i + 1;
            }
            if(map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
