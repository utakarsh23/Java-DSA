package LeetCode;

class SpecialPositionInABinaryMatrix {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1,0,0,0},{0,0,1,0},{1,0,0,1}}));
    }
    public static int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // boolean row[] = new boolean[n];
        // boolean col[] = new boolean[m];

        // int i = 0;
        // for(int[] arr : mat) {
        //     int one = 0;
        //     for(int x : arr) {
        //         if(x == 1) {
        //             one++;
        //         }
        //     }
        //     if(one == 1) row[i] = true;
        //     i++;
        // }

        // for(int j = 0; j < m; j++) {
        //     one = 0;
        //     for(int k = 0; k < n; k++) {
        //         if(mat[k][j] == 1) {
        //             one++;
        //         }
        //     }
        //     if(one == 1) row[j] = true;
        // }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    ans += helperCheck(mat, i, j, m, n);
                }
            }
        }
        return ans;
    }
    public static int helperCheck(int[][] mat, int row, int col, int m, int n) {

        int r1 = 0;
        for(int i = 0; i < n; i++) {
            if(mat[row][i] == 1) r1++;
        }
        int c1 = 0;
        for(int i = 0; i < n; i++) {
            if(mat[i][col] == 1) c1++;
        }
        return (c1 + r1) == 2 ? 1 : 0;
    }

    public static int numSpecia1(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }

                boolean good = true;
                for (int r = 0; r < m; r++) {
                    if (r != row && mat[r][col] == 1) {
                        good = false;
                        break;
                    }
                }

                for (int c = 0; c < n; c++) {
                    if (c != col && mat[row][c] == 1) {
                        good = false;
                        break;
                    }
                }

                if (good) {
                    ans++;
                }
            }
        }

        return ans;
    }
}