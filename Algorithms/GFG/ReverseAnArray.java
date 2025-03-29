package GFG;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6};
        revArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void revArray(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i <= j) {
            swap(arr, i++, j--);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
