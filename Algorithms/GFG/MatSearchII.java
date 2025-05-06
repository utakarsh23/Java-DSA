package GFG;

import java.util.Arrays;

public class MatSearchII {
    public static void main(String[] args) {

    }
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        // int row = mat.length;
        // for(int i = 0; i < row; i++) {
        //     if(search(mat[i], x)) {
        //         return true;
        //     }
        // }
        // return false;
        for(int[] arr : mat) {
            if(Arrays.binarySearch(arr, x) >= 0) return true;
        }
        return false;
    }
    public boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while(start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] > target) {
                end = mid -1;
            } else if(arr[mid] < target) {
                start = mid +1;
            } else {
                return true;
            }
        }
        return false;
    }
}
