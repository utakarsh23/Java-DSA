package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MakeArrayElementsEqualToZero {

    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[] {1,0,2,0,3}));
    }
    public static int countValidSelections(int[] nums) {

        /*
        0 1 2 3 4
        1,0,2,0,3
        1 1 3 3 6
        */


        int len = nums.length;
        int[] p = new int[len];
        p[0] = nums[0];
        List<Integer> indexes = new ArrayList<>();
        if(p[0] == 0) indexes.add(0);
        for(int i = 1; i < len; i++) {
            p[i] = p[i-1]+nums[i];
            if(nums[i] == 0) indexes.add(i);
        }

        int c = 0;
        for(int x : indexes) {
            int sl = p[x];
            int sr = p[len-1]-p[x];
            if(sl == sr) {
                c+=2;
            } else if(sl == sr+1) {
                c++;
            } else if(sl+1 == sr) {
                c++;
            }
        }
        return c;
    }
}
