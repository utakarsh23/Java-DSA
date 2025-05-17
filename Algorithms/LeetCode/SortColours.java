package LeetCode;

import java.util.Arrays;

public class SortColours {
    public static void main(String[] args) {
        int[] arr = new int[] {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void sortColors(int[] arr) {
        // boolean swapped;
        // for (int i = 0; i < nums.length; i++) {
        //     swapped = false;
        //     for (int j = 1; j < nums.length-i; j++) {
        //         if(nums[j] < nums[j-1]) {
        //             int temp = nums[j];
        //             nums[j] = nums[j-1];
        //             nums[j-1] = temp;
        //             swapped = true;
        //         }
        //     }
        //     if(!swapped) {
        //         break;
        //     }
        // }
        int start = 0, end = arr.length-1, mid = 0;
        while(mid <= end) {
            if(arr[mid] == 0) {
                swap(arr, start++, mid++);
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, end--);
            }
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
