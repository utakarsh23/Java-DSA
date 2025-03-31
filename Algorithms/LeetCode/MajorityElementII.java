package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] no = {3,2,3};
        System.out.println(majorityElement(no));
    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> li = new ArrayList<>();
        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                li.add(key);
            }
        }
        return li;
    }
}
