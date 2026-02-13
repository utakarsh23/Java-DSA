package Sorting.BubbleSort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arrr = {-1, 2, -5, 9, 0, 27, -99};
        bubbleSort(arrr);
        System.out.println(Arrays.toString(arrr));
    }
    //Main
    static void bubbleSort(int[] nums) {
        boolean swapped;
        for (int i = 0; i < nums.length; i++) {
            swapped = false;
            for (int j = 1; j < nums.length-i; j++) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
