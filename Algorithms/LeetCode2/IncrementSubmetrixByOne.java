package LeetCode2;

public class IncrementSubmetrixByOne {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] arr = new int[n][n];
            for(int[] x : queries) {
                helper(arr, x);
            }
            return arr;
        }
        void helper(int[][] arr, int[] x) {
            int len = arr.length;
            for(int i = x[0]; i <= x[2]; i++) {
                for(int j = x[1]; j <= x[3]; j++) {
                    arr[i][j]++;
                }
            }
        }
}
