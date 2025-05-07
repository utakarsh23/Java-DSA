package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,1},{1,0,1},{0,1,1}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
    static void setZeroes(int[][] matrix) {
        List<int[]> li = new ArrayList<>();
        int row = matrix.length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    li.add(new int[] {i, j});
                }
            }
        }
        //for rows
        for (int i = 0; i < li.size(); i++) {
            int s = li.get(i)[0];
            Arrays.fill(matrix[s], 0);
        }
        //for cols
        for (int i = 0; i < li.size(); i++) {
            int s = li.get(i)[1];
            rowChange(matrix, s);
        }
    }

    private static void rowChange(int[][] matrix, int s) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][s] = 0;
        }
    }
}
