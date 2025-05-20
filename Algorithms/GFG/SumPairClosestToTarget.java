package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumPairClosestToTarget {
    public static void main(String[] args) {
        System.out.println(sumClosest(new int[] { 1, 6, 3, 5, 3, 2}, 12));
    }
    static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        if(n < 2) return new ArrayList<>();

        Arrays.sort(arr);
        int left = 0, right = n-1;
        List<Integer> result = new ArrayList<>();
        int closestDiff = Integer.MAX_VALUE;
        while(left < right) {
            int currSum = arr[left] + arr[right];
            int currDiff = Math.abs(target -  currSum);
            if(currDiff < closestDiff) {
                closestDiff = currDiff;
                result.clear();
                result.add(arr[right]);
                result.add(arr[left]);
            } else if (currDiff == closestDiff) {
                int prevDiff = Math.abs(result.get(1) - result.get(0));
                int currAbsDiff = Math.abs(arr[right] - arr[left]);

                if(currAbsDiff > prevDiff) {
                    result.clear();
                    result.add(arr[right]);
                    result.add(arr[left]);
                }
            }
            if(currSum < target) {
                left++;
            } else if(currSum > target) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        Collections.sort(result);
        return result;

    }
}
