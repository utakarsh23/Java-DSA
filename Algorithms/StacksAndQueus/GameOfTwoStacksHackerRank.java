package StacksAndQueus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameOfTwoStacksHackerRank {
    public static void main(String[] args) {

    }
    public static int twoStacks(int maxSum, ArrayList<Integer> arr, ArrayList<Integer> arr1) {
        int[] a = arr.stream().mapToInt(Integer::intValue).toArray();
        int[] b = arr1.stream().mapToInt(Integer::intValue).toArray();
        return helperFunc(maxSum, Arrays.copyOfRange(a, 0, a.length), Arrays.copyOfRange(b, 0, b.length), 0, 0);
    }

    private static int helperFunc(int maxSum, int[] a, int[] b, int sum, int count) {
        if(a.length == 0 || b.length == 0) {
            return count;
        }
        if(sum > maxSum) return count;
        int ans1 = helperFunc(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
        int ans2 = helperFunc(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum+b[0], count+1);

        return Math.max(ans2, ans1);
    }
}
