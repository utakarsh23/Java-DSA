package LeetCode;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[100];
        for(int x : nums) {
            arr[x-1]++;
        }
        int max = Integer.MIN_VALUE;
        for(int x : arr) {
            max = Math.max(x, max);
        }
        int c = 0;
        for(int x : arr) {
            if(x == max) {
                c++;
            }
        }
        return c*max;
    }
}
