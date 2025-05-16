package GFG;

import java.util.HashMap;
import java.util.Map;

public class CountSubArray {
    public static void main(String[] args) {

    }
    public int countSubarrays(int arr[], int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int currSum = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum == k) {
                res++;
            }
            if(map.containsKey(currSum - k)) {
                res += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
