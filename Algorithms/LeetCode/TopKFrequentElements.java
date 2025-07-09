package LeetCode;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2)));
    }
    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        Map<Integer, Integer> sortedByValue = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        int[] arr = new int[k];
        int i = 0;
        for (int x : sortedByValue.keySet()) {
            if(i == k) break;
            arr[i++] = x;
        }

        return arr;
    }
}
