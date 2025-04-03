package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(arr));
    }

    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> li = new ArrayList<>();
        for(Integer key : map.keySet()) {
            int w = map.get(key);
            if(w > nums.length/3) {
                li.add(key);
            }
        }
        return li;
    }
}
