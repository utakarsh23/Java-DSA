package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElements {
    public static void main(String[] args) {

    }
    static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if((num & 1) == 0) map.put(num, map.getOrDefault(num, 0)+1);
        }
        ArrayList li = new ArrayList();
        int min = Integer.MAX_VALUE;
        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                li.add(key);
            }
        }
        return 5;
    }
}
