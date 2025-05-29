package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CheckSUbArraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum1(new int[] {23,2,4,6,6}, 7));
    }

//    static boolean checkSubarraySum(int[] arr, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        int len = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if(sum == k) len = Math.max(len, i + 1);
//            int rem = sum-k;
//            if(map.containsKey(rem)) {
//                int currlen = i - map.get(rem);
//                len = Math.max(currlen, len);
//            }
//            if(!map.containsKey(sum)) {
//                map.put(sum, i);
//
//            }
//        }
//        return len > 0;
//    }


    //m2
    static boolean checkSubarraySum1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = k == 0 ? sum : sum % k;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) return true;
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
