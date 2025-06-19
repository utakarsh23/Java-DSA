package LeetCode;

public class Convert1DArraysinto2DArrays {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) return new int[][] {};
        int p1 = 0;
        int p2 = 0;
        int[][] arr = new int[m][n];
        while(p1 < original.length) {
            for(int i = 0; i < n; i++) {
                arr[p2][i] = original[p1++];
            }
            p2++;
            // p1++;
        }
        return arr;
    }
}
