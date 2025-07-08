package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public static void main(String[] args) {
        System.out.println();
    }
    static int findLucky(int[] arr) {
        //huhh
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = -1;
        for(int x : map.keySet()) {
            if(map.get(x) == x) {
                ans = x;
            }
        }
        return ans;
    }
}
