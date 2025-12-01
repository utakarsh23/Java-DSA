package Randoms;

import java.util.*;

public class AllSum {
    public static void main(String[] args) {
        System.out.println(addSum(new int[] {2, 4, 5, 6, 9, 11, 16, 8, 3}, 0, 8));
    }
    private static Set<Integer> addSum(int[] arr, int s, int e) {
        if(s >= e) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            set.add(arr[s]);
            return set;
        }

        int m = s + (e - s)/2;

        Set<Integer> left = addSum(arr, s, m);
        Set<Integer> right = addSum(arr, m+1, e);
        return merge(left, right);
    }


    static Set<Integer> merge(Set<Integer> left, Set<Integer> right) {
        Set<Integer> set = new HashSet<>();
        for (int a : left) {
            for (int b : right) {
                set.add(a + b);
            }
        }
        return set;
    }
}
