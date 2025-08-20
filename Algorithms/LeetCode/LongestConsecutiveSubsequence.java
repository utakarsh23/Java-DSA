package LeetCode;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
    public static int longestConsecutive(int[] nums) {
        int m = max(nums);
        int[] arr = new int[m+1];
        for(int x : nums) {
            arr[x]++;
        }

        int max = 0;
        for(int i = 1; i < arr.length; i++) {
            int c = 1;
            while(i < arr.length && arr[i-1] != 0 && arr[i] != 0 && (arr[i] >= arr[i-1] || arr[i] <= arr[i-1])) {
                i++;
                c++;
            }
            max = Math.max(max, c);
        }

        return max;
    }
    static int max(int[] arr) {
        return STL.max(arr);
    }
}
