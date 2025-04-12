package LeetCode;

public class SortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(check(arr));
    }
        static boolean check(int[] nums) {
            int peakInd = 0;
            int count = 0;
            for(int i = 0; i < nums.length-1; i++) {
                if(nums[i + 1] < nums[i]) {
                    peakInd = i;
                    count++;
                }
            }
            if(count > 1) return false;
            if(count == 0) return true;
            reverse(nums, 0, peakInd);
            reverse(nums, peakInd + 1, nums.length-1);
            reverse(nums, 0, nums.length-1);
            for(int i = 0; i < nums.length-1; i++) {
                if(nums[i] > nums[i+1]) {
                    return false;
                }
            }
            return true;

        }
    static void reverse(int[] arr, int start, int end) {
            while(start < end) {
                swap(arr, start++, end--);
            }
        }
    static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
