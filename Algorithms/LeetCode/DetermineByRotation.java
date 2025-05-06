package LeetCode;

public class DetermineByRotation {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] tar = new int[][] {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(findRotation1(arr, tar));
    }
    //m1
    static boolean findRotation1(int[][] a, int[][] b) {
        int n=a.length;
        int c90=0,c180=0,c270=0,c0=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(b[i][j]==a[n-j-1][i])
                    c90++;
                if(b[i][j]==a[n-i-1][n-j-1])
                    c180++;
                if(b[i][j]==a[j][n-i-1])
                    c270++;
                if(b[i][j]==a[i][j])
                    c0++;
            }
        }

        return (c90==n*n||c270==n*n||c180==n*n||c0==n*n);
    }
    //m2
    static boolean findRotation(int[][] mat, int[][] target) {
        int count = 0;
        for(int k = 0; k < 4; k++) {
            rotateby90(mat);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if(mat[i][j] != target[i][j]) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count == 0;
    }
    static void rotateby90(int mat[][]) {
        for(int i = 0; i < mat.length; i++) {
            swapRev(mat[i]);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat.length; j++) {
                swap(mat, i, j);
            }
        }
    }
    static void swap(int[][] arr, int a, int b) {
        int temp = arr[a][b];
        arr[a][b] = arr[b][a];
        arr[b][a] = temp;
    }
    static void swapRev(int[] arr) {
        int i = 0;
        while (i < arr.length/2) {
            swap(arr, i, arr.length-1-i);
            i++;
        }
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
