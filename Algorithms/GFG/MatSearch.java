package GFG;

public class MatSearch {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 30, 38},{20, 52, 54},{35, 60, 69}};
        int tar = 52;
        System.out.println(matSearch(arr, tar));
    }
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int ans = -1;
        int rows = mat.length;
        for(int i = rows-1; i >= 0; i--) {
            if(mat[i][mat[0].length-1] <= x) {
                 ans = countStart(mat[i], x);
                 break;
            }
        }
        return !(ans == -1);

    }
    public static int countStart(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) return x;
        }
        return -1;
    }
}
