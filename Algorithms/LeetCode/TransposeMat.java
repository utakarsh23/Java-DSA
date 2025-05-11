package LeetCode;

import java.util.Arrays;

class TransposeMat {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][] {{1, 2, 3}, {4, 5, 6}})));
    }
    static int[][] transpose(int[][] mat) {
        int[][] arr = new int[mat[0].length][mat.length];
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                arr[j][i] = mat[i][j];
            }
        }
        return arr;
    }
}