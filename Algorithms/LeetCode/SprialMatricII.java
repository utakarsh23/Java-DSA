package LeetCode;

import java.util.Arrays;

public class SprialMatricII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
    public static int count = 0;

    static public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int start = 0;
        int end = arr.length;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            rowFunc(arr, start++, end, row++);
            colFunc(arr, start, end--, arr.length-1-col++);
            reverseRowFunc(arr, arr.length-start++, arr.length-end, arr.length-row++);
            reverseColFunc(arr, start, end, arr.length-1-col++);
        }

        return arr;
    }

    static void rowFunc(int[][] arr, int start, int end, int row) {
        if(count == arr.length*arr.length) return;
        for (int i = start; i < end; i++) {
            arr[row][i] = ++count;
        }
    }


    static void reverseRowFunc(int[][] arr, int start, int end, int row) {
        if(count == arr.length*arr.length) return;
        for (int i = end; i <= start; i--) {
            arr[row][i] = ++count;
        }
    }


    static void colFunc(int[][] arr, int start, int end, int col) {
        if(count == arr.length*arr.length) return;
        colChange(arr, start, end, col);
    }

    static void colChange(int[][] arr, int start, int end, int col) {
        for (int i = start; i < end; i++) {
            arr[i][col] = ++count;
        }
    }

    static void reverseColFunc(int[][] arr, int start, int end, int col) {
        if(count == arr.length*arr.length) return;
        colChangeRev(arr, start, end, col);
    }

    static void colChangeRev(int[][] arr, int start, int end, int col) {
        for (int i = end; i > start; i--) {
            arr[i][col] = ++count;
        }
    }

}
