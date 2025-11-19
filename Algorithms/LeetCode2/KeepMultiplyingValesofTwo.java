package LeetCode2;

import java.util.Arrays;

public class KeepMultiplyingValesofTwo {
    public int findFinalValue(int[] nums, int original) {
        // for(int i = 0; i< nums.length; i++) {
        //     if(nums[i] == original) {
        //         original *=2;
        //         i = -1;
        //     }
        // }
        // return original;
        Arrays.sort(nums);
        int t = original;
        while(original != -1) {
            t = original;
            original = bs(nums, original);
            t = original == -1 ? t : original;
        }
        return t;
    }
    static int bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return target*2;
            }
        }
        return -1;
    }

    // 1, 3, 5, 6, 12 : t = 3;
    // s:0          e:4
    // 1, 3, 5, 6, 12 : mid > tar
    // s:0   e:2
    // 1, 3, 5, 6, 12 : mid == tar
    // s:0   e:2
    //ret 6;

    // 1, 3, 5, 6, 12 : t = 6;
    // s:0         e:4
    // 1, 3, 5, 6, 12 : mid < tar
    //         s:3 e:4
    // 1, 3, 5, 6, 12 : mid == tar
    //         s:3 e:4
    //ret 12;

    // 1, 3, 5, 6, 12 : t = 12;
    // s:0         e:4
    // 1, 3, 5, 6, 12 : mid < tar
    //         s:3 e:4
    // 1, 3, 5, 6, 12 : mid < tar
    //         s:3 e:4
    // 1, 3, 5, 6, 12 : mid < tar
    //         s:3 e:4
    //ret 12;

    // 2 7 9 : t = 4;
    // s:0 s:2 : m > tar
    // s:0, e:1 : m < tar
    // s:1, e:1 : m > tar
    // s:

    //
}
