package GFG;

import java.util.Arrays;

public class rotateArray {
    public static void main(String[] args) {
        int[] arr = {7,3,9,1};
        int d = 9;
        rotateArrays1(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateArrays(int[] arr, int d) {
        d = d% arr.length;
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

    //m2
    static void rotateArrays1(int[] arr, int d) {
        d = d% arr.length;
        reverse(arr, 0, arr.length-1-d);
        reverse(arr, arr.length-d, arr.length-1);
//        reverse(arr, 0, arr.length-1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
