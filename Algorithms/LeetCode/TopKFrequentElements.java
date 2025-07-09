package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2)));
    }
    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Map<Integer, Integer> ansMap = new HashMap<>();
        for(int x : map.keySet()) {
            ansMap.put(map.get(x), x);
        }
        int[] arr = new int[k];
        int i = 0;
        for (int x : ansMap.keySet()) {
            arr[i%k++] = x;
        }

        return arr;
    }
}
