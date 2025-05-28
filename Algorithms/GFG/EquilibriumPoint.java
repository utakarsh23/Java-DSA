package GFG;

public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
        int[][] preSuf = new int[arr.length][2];
        int left = 0;
        int right = 0;
        for(int i = 0; i < arr.length; i++) {
            left += arr[i];
            right += arr[arr.length-1-i];
            preSuf[i][0] = left;
            preSuf[arr.length-1-i][1] = right;
        }
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(preSuf[i][0] == preSuf[i][1]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
