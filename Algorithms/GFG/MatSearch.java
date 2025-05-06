package GFG;

public class MatSearch {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 30, 38},{20, 52, 54},{35, 60, 69}};
        int tar = 60;
        System.out.println(matSearch(arr, tar));
    }
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int rows = mat.length;
        for(int i = 0; i < rows; i++) {
            if(mat[i][mat[0].length-1] >= x) {
                 return countStart(mat[i], x);
            }
        }
        return false;

    }
    public static boolean countStart(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) return true;
        }
        return false;
    }
}
