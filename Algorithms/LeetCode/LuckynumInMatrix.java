package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LuckynumInMatrix {
    public static void main(String[] args) {

    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        for(int[] arr : matrix) {
            int min = Integer.MAX_VALUE;
            for(int x : arr) {
                min = Math.min(min, x);
            }
            row.add(min);
        }
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for(int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            col.add(max);
        }
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == row.get(i) && matrix[i][j] == col.get(j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}
