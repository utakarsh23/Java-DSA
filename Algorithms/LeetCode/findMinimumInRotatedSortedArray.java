package LeetCode;

class findMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
       int start = 0;
       int end = nums.length-1;
       while(start < end) {
        int mid = start+(end-start)/2;
            if(nums[mid] > nums[mid+1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
       }
       return nums[(end+1) % nums.length];
    }
}