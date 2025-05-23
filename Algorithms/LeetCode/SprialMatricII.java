package LeetCode;

import java.util.Arrays;

public class SprialMatricII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Left to Right
            for (int i = left; i <= right; i++) {
                arr[top][i] = count++;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = count++;
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = count++;
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = count++;
                }
                left++;
            }
        }

        return arr;
    }
}