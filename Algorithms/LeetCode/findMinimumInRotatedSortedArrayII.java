package LeetCode;

class findMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(nums[start] < nums[end]) return nums[start];
        while(start < end){
            int mid = start + (end - start) / 2;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }
}