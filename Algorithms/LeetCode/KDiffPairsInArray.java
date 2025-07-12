package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[] {1,2,3,4,5}, 1));
    }
    static public int findPairs(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            int count = 0;
            for(int x : map.keySet()) {
                if(k == 0) {
                    if(map.get(x) > 1) count++;
                } else {
                    if(map.containsKey(x + k)) count++;
                }
            }
            return count;
        }
    }
}
