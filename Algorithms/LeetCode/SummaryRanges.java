package LeetCode;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] {}));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (i < nums.length - 1 && nums[i + 1]  == nums[i] + 1) {
                i++;
            }
            if(i != j)
                list.add(nums[j] + "->" + nums[i]);
            else
                list.add(Integer.toString(nums[i]));
        }
        return list;
    }
}