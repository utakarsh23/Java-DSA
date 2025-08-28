package CodeChef.S201;

import java.util.Scanner;

public class Hugegrid {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            String A = sc.next();
            char[] ars = A.toCharArray();
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i <= j) arr[i][j] = f(ars, i, j);
                    else arr[i][j] = arr[j][i];
                }
            }

        }
        System.out.println(out);
    }

    static int countPaths(int[][] arr, int row, int col, int sum) {
        if(row == 1 || col == 1) {
            return sum;
        }
        int left = countPaths(arr, row-1, col, sum + arr[row-1][col]);
        int right = countPaths(arr, row, col-1, sum + arr[row][col-1]);

        return Math.min(left, right);
    }


    static int f(char[] arr, int s, int e) {
        int sum = 0;
        for(int i = s; i < e; i++) {
            sum += arr[i]-'0';
        }
        return sum;
    }
}
