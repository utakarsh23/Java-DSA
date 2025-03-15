package Recursion.Arrays;

public class MinValInArr {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, -1, 8, 2};
        System.out.println(arrMin(arr, Integer.MAX_VALUE, 0));
    }

    private static int arrMin(int[] arr, int min, int ind) {
        if(arr[ind] < min) {
            min = arr[ind];
        }
        if(arr.length-1 == ind) return min;
        return arrMin(arr, min, ind+1);
    }
}
