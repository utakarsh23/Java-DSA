package GFG;

import java.util.Arrays;

public class MinimizeTheHeightsII {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int result = arr[arr.length-1]-arr[0];
        int largest = arr[arr.length-1]-k;
        int smallest = arr[0]+k;

        for(int i = 0; i < arr.length-1; i++) {
            int min = Math.min(smallest, arr[i+1] - k);
            int max = Math.max(largest, arr[i] + k);
            if(min < 0) continue;
            result = Math.min(result, max-min);
        }
        return result;
    }
}
