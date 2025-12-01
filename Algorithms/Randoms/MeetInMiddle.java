package Randoms;

import java.util.*;

public class MeetInMiddle {

    public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;
        int mid = n / 2;

        // Left and right halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        // Generate subset sums for both halves
        List<Integer> leftSums = generateSums(left);
        List<Integer> rightSums = generateSums(right);

        // Sort right to allow binary search
        Collections.sort(rightSums);

        // For each left sum, search if target - leftSum exists in right
        for (int sum : leftSums) {
            int need = target - sum;
            if (Collections.binarySearch(rightSums, need) >= 0) {
                return true;
            }
        }

        return false;
    }

    // Generate all subset sums for arr[]
    private static List<Integer> generateSums(int[] arr) {
        int n = arr.length;
        int total = 1 << n;

        List<Integer> sums = new ArrayList<>(total);

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            sums.add(sum);
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 9, 11, 16, 8, 3};
        int target = 27;

        System.out.println(subsetSum(arr, target)
                ? "Subset exists with sum = " + target
                : "No subset found");
    }
}