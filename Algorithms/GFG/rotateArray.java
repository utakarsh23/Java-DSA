package GFG;

import java.util.Arrays;

public class rotateArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d = 3;
        rotateArrays(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateArrays(int[] arr, int d) {
        int[] dumArr = new int[d];
        int i = 0;
        for (i = 0; i < d; i++) {
            dumArr[i] = arr[i];
        }
        int j = 0;
        while (i < arr.length){
            arr[j++] = arr[i++];
        }
        i = 0;
        while (j < arr.length) {
            arr[j++] = dumArr[i++];
        }
    }
}
