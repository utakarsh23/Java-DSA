package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class CheckIfAllOnesAreAtADistantK {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] == 1) {
                list.add(i);
            }
        }
        len = list.size();
        int f = len == 0 ? Integer.MIN_VALUE : list.getFirst();
        for(int i = 1; i < len; i++) {
            int x = list.get(i);
            if(x - f <= k) {
                return false;
            }
            f = x;
        }
        return true;
    }
}
