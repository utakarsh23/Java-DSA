package GFG;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        System.out.println(countTriangles(new int[] {1, 4, 6, 7}));
    }
    static int countTriangles(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        for(int k = n-1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while(i < j) {
                if(arr[i] + arr[j] > arr[k]) {
                    count += (j-i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
