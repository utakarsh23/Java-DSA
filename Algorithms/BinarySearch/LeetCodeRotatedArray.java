package BinarySearch;//https://leetcode.com/problemms/search-in-rotated-sorted-array/description/

/*Approach
*we have to find pivot in the Array,
*the array pattern will be like [asc, pivot, asc]
*now in search method, we check if the target is on which side of teh pivot and execute
 */

import java.util.Arrays;

//this won't work with duplicate values
public class LeetCodeRotatedArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 0};
        int target = 0;
//        int[] ars = Arrays.copyOfRange(arr, 0, 3);
        System.out.println(search(arr, target));
    }

    static int search(int[] nums, int target) {
        int pivot = pivotInRotatedArray(nums);
        if(pivot == -1) {
            //normal binary search when no pivot found
            return binarySearch(nums, target, 0 , nums.length-1);
        }
        /*if pivot is found then we will have cases, as we have 2 ascending cases if pivot is found.
        Cases are as:
        i) when Pivot is the target element, we return the pivot as the targeted index
        ii) when target < starting element, then the target element resides on the right ascending of the pivot
        iii) when target element > start, it resides on the left ascending side of teh pivot
        */
        //Case 1
        if(nums[pivot] == target) {
            return pivot;
        }
        //Case 3
        if(target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        }
        //Case 2
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    static int pivotInRotatedArray(int[] nums) {
    /*to check Pivot, some cases can be defined
      i) when middle element > middle element+1 (nums[mid] > nums[mid + 1]), that is the pivot is found, and it is the middle element
      ii) when middle element < middle element-1 (nums[mid] < nums[mid - 1]). i.e : Pivot is found, and it is the element before middle element(mid-1_
      iii) when start element >= middle element and every element after middle element will be smaller than start element
           so we can basically ignore them and start to look for the peak (end = mid-1)
      iv) when start element < middle element then we shift start to the next element of the middle one
          -> (start = mid+1)
        */
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start - (start - end) / 2;
            //1st case here
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            //2nd case here
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid-1;
            }
            //3rd case here
            if (nums[start] >= nums[mid]) {
                end = mid-1;
            }
            //4th case here
            else
            {
                start = mid+1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start - (start - end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
