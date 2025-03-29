package GFG;

import java.util.Arrays;

public class first {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        getSecondLargest(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int getSecondLargest(int[] arr) {
        int i = arr.length-1;
        while(i > 0) {
            if(arr[i-1] != arr[i]) {
                return arr[i-1];
            }
            i--;
        }
        return -1;
    }
}
