package BinarySearch;//https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class LeetCodePeakIndex {
    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 2, 3, 4};
//        System.out.println(peakIndexInMountainArrays(nums));
        System.out.println(peakIndexInMountainArrayss(nums));
//        System.out.println(peakIndexInMountainArray(nums));

    }
    static int peakIndexInMountainArrays(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start - (start - end) / 2;
            if (nums[mid] > nums[mid+1]) { //-dec
                end = mid - 1;
            } if (nums[mid] < nums[mid+1]) {
                start = mid + 1;
            }
        }
        return start; //!= return end
    }

//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------

//it's around same as the above one s
    static int peakIndexInMountainArrayss(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start - (start - end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                //here we are in decreasing part, "end = mid-1" could be an answer, but we have to look at left too
                //which in upper open we took care of, but not in this one so end != mid-1
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; //or return end; cause both are same in the end
    }

//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------


    static int peakIndexInMountainArray(int[] arr) {
            for(int i = 0; i< arr.length; i++){
                if(arr[i]<arr[i+1]){

                }
                else{
                    return i;
                }
            }
            return -1;
        }
}
