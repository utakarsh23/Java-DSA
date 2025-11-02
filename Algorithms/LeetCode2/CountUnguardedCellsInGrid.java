package LeetCode2;

import java.util.HashSet;
import java.util.Map;

class CountUnguardedCellsInGrid {
    public static void main(String[] args) {
        System.out.println(countUnguarded(4, 6, new int[][] {{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}}));
    }

    //m1 - tle
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] arr = new boolean[m][n];
        boolean[][] ansArr = new boolean[m][n];
        for(int[] x : walls) {
            arr[x[0]][x[1]] = true;
            ansArr[x[0]][x[1]] = true;
        }
        for (int[] x : guards) {
            bfsdfs(ansArr, arr, x[0], x[1]);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!ansArr[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    static void bfsdfs(boolean[][] ansArr, boolean[][] arr, int row, int col) {
        int rl = arr.length;
        int cl = arr[0].length;
        //col right
        for (int i = col; i < cl; i++) {
            if(!arr[row][i]) {
//                set.add(new int[] {row, i});
                ansArr[row][i] = true;
            } else {
                break;
            }
        }
        //col left
        for (int i = col; i >= 0; i--) {
            if(!arr[row][i]) {
//                set.add(new int[] {row, i});
                ansArr[row][i] = true;
            } else {
                break;
            }
        }

        //row down
        for (int i = row; i < rl; i++) {
            if(!arr[i][col]) {
//                set.add(new int[] {i, col});
                ansArr[i][col] = true;
            } else {
                break;
            }
        }
        //row up
        for (int i = row; i >= 0; i--) {
            if(!arr[i][col]) {
//                set.add(new int[] {row, i});
                ansArr[i][col] = true;
            } else {
                break;
            }
        }
    }

    public static int countUnguarded1(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] guard = new boolean[m][n];
        boolean[][] wall = new boolean[m][n];
        boolean[][] seen = new boolean[m][n];

        for(int[] x : walls) seen[x[0]][x[1]] = true;
        for(int[] x : guards) seen[x[0]][x[1]] = true;

        boolean watched = true;
        for (int i = 0; i < n; i++) {
            watched = false;
            for (int j = 0; j < m; j++) {
                if(guard[i][j]) watched = true;
                else if(wall[i][j]) watched = false;
                else if(watched) seen[i][j] = true;
            }
            watched = false;
            for (int j = m-1; j >= 0; j--) {
                if(guard[j][i]) watched = true;
                else if(wall[j][i]) watched = false;
                else if(watched) seen[j][i] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            watched = false;
            for (int j = 0; j < n; j++) {
                if(guard[i][j]) watched = true;
                else if(wall[i][j]) watched = false;
                else if(watched) seen[i][j] = true;
            }
            watched = false;
            for (int j = n-1; j >= 0; j--) {
                if(guard[j][i]) watched = true;
                else if(wall[j][i]) watched = false;
                else if(watched) seen[j][i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!wall[i][j] && !guard[i][j] && !seen[i][j]) count++;
            }
        }
        return count;
    }

    public static int countUnguarded2(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] wall = new boolean[m][n];
        boolean[][] guard = new boolean[m][n];
        boolean[][] seen = new boolean[m][n];

        // Mark walls and guards
        for (int[] w : walls) wall[w[0]][w[1]] = true;
        for (int[] g : guards) guard[g[0]][g[1]] = true;

        // Row-wise scanning
        for (int i = 0; i < m; i++) {
            boolean watching = false;
            for (int j = 0; j < n; j++) { // left → right
                if (wall[i][j]) watching = false;
                else if (guard[i][j]) watching = true;
                else if (watching) seen[i][j] = true;
            }
            watching = false;
            for (int j = n - 1; j >= 0; j--) { // right → left
                if (wall[i][j]) watching = false;
                else if (guard[i][j]) watching = true;
                else if (watching) seen[i][j] = true;
            }
        }

        // Column-wise scanning
        for (int j = 0; j < n; j++) {
            boolean watching = false;
            for (int i = 0; i < m; i++) { // top → bottom
                if (wall[i][j]) watching = false;
                else if (guard[i][j]) watching = true;
                else if (watching) seen[i][j] = true;
            }
            watching = false;
            for (int i = m - 1; i >= 0; i--) { // bottom → top
                if (wall[i][j]) watching = false;
                else if (guard[i][j]) watching = true;
                else if (watching) seen[i][j] = true;
            }
        }

        // Count unguarded
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!wall[i][j] && !guard[i][j] && !seen[i][j]) count++;
            }
        }
        return count;
    }
}