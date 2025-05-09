package GFG;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumII(arr, target)));
    }
    static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return new int[] {i+1, j+1};
                }
            }
        }
        return new int[] {-1, -1};
    }

    static boolean twoSum1(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            int col = target - arr[i];
            if(set.contains(col)) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    static int[] twoSumII(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while(numbers[start] + numbers[end] != target) {
            if(numbers[start] + numbers[end] < target) start++;
            else end--;
        }
        return new int[] {start+1, end+1};
    }

}
