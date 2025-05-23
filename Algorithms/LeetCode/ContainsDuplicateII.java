package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {0,1,2,3,4,0,0,7,8,9,10,11,12,0}, 1));
    }
    static boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[i] == nums[j] && Math.abs(i - j) <= k)
//                     return true;
//             }
//         }
        Map<Integer, Integer> map =  new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if(map.containsKey(ele) && Math.abs(i-map.get(ele)) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
