package LeetCode;

import java.util.*;

public class InterSectionofMultipleRrays {
    public static void main(String[] args) {
        System.out.println(intersection(new int[][]{{7,34,45,10,12,27,13}, {27,21,45,10,12,13}}));
    }
    static List<Integer> intersection(int[][] nums) {
        int[] arr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr = interSecOfTwo(arr, nums[i]);
        }
        Arrays.sort(arr);
        List<Integer> li = new ArrayList<>();
        for (int x : arr) {
            li.add(x);
        }
        return li;
    }

    private static int[] interSecOfTwo(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for(int num1 : nums1) first.add(num1);
        for(int num2 : nums2) if(first.contains(num2)) second.add(num2);
        int[] ss = new int[second.size()];
        int i = 0;
        for(int x : second) {
            ss[i] = x;
            i++;
        }
        return ss;
    }
}
