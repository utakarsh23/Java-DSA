package Recursion.Arrays;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -70};
        System.out.println(arrrSum(arr));
    }


    //m1
    private static int arraySum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int[] arr1 = Arrays.copyOfRange(arr, 1, arr.length);
        return arraySum(arr1) + arr[0];
    }

    //m2

    private static int arrSum(int[] arr, int pos) {
        if(pos >= arr.length) {
            return 0;
        }
        int val = arr[pos];
        return val + arrSum(arr, pos+1);
    }

    //m3
    //kinda twp pointers like
    private static int arrrSum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int val1 = arr[0];
        int val2 = arr[arr.length-1];
        int[] arr1 = Arrays.copyOfRange(arr, 1, arr.length-1);
        return arrrSum(arr1) + val1 + val2;
    }
}
