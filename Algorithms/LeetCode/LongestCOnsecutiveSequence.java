package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestCOnsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
    static public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map.keySet());
        int max = 0;
        int temp = 0;
        int i = 0;
        int count = 0;
        for(int x : map.keySet()) {
            if(i == 0) {
                i++;
                temp = x;
            }
            if(x == temp + 1) {
                count ++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
