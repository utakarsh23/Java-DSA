package GFG;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithXOR {
    public static void main(String[] args) {

    }
    static public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int xors = 0;
        for(int i = 0; i < arr.length; i++) {
            xors ^= arr[i];
            res += map.getOrDefault(xors^k, 0);
            if(xors == k) res++;
            map.put(xors, map.getOrDefault(xors, 0) + 1);
        }
        return res;
    }
}
