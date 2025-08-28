package LeetCode;

import java.util.Arrays;

class SortMatrixByDiagonals {

    class str {
        int n;
        int[] arr = new int[n * n];

        str(int n) {
            this.n = n;
        }

        void sorts() {
            Arrays.sort(this.arr);
        }
    }


    public int[][] sortMatrix(int[][] grid) {
        int size = (2 * grid.length)-1;
        
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new int[][] {{1,7,3},{9,8,2},{4,5,6}}));
    }
}