package GFG;

import java.util.Arrays;

public class RotateBy90 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 2}, {3, 4}};
        rotateby90(arr);
        System.out.println(Arrays.deepToString(arr));
    }
    static void rotateby90(int mat[][]) {
        for(int i = 0; i < mat.length; i++) {
            swapRev(mat[i]);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat.length; j++) {
                swap(mat, i, j);
            }
        }
    }
    static void swap(int[][] arr, int a, int b) {
        int temp = arr[a][b];
        arr[a][b] = arr[b][a];
        arr[b][a] = temp;
    }
    static void swapRev(int[] arr) {
        int i = 0;
        while (i < arr.length/2) {
            swap(arr, i, arr.length-1-i);
            i++;
        }
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
