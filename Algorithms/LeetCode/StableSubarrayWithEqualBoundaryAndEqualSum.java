package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StableSubarrayWithEqualBoundaryAndEqualSum {

    public static void main(String[] args) {
        System.out.println(countStableSubarray(new int[] {536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912}));
        //536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912
    /*      0           1           2       3       4           5       6           7       8           9       10          11
            11, 9 - 10, 8 - 9, 7 - 8, 6 - 7, 5 - 6, 4 - 5, 3 - 4, 2 - 3, 1 - 2, 0

         */
    }

    public static long countStableSubarray(int[] capacity) {
        /*
            i                       j
            9     3     3     3     9    11
            9     12    15    18    27   38
            38    29    26    23    20   11


            e = 9, 
            
        */
        int len = capacity.length;
        long[] arr = new long[len];
        int i = 0;
        long s = 0;
        int p = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int x : capacity) {
            s += x;
            arr[i] = s;
            if(!map.containsKey(x)) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(i);
                map.put(x, a);
            } else {
                map.get(x).add(i);
            }
            i++;
        }
        // int len = i+1;
        // for(i =0; i < len; i++) {
        //     arr[i++][]
        // }

        long count = 0;
        for(int x : map.keySet()) {
            List<Integer> integers = map.get(x);
            int leni = integers.size() - 1;
            for(int j = leni; j >= 0; j--) {
                for(int k = j - 1; k >= 0; k--) {
                    int f = integers.get(k);
                    int l = integers.get(j);
                    if(Math.abs(l - f) >= 2) {
                        long i1 = arr[l-1];
                        long i2 = arr[f];
                        long target = i1 - i2;
                        if(target == x){
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }


        return count;
    }


    public static long countStableSubarray1(int[] capacity) {
        int len = capacity.length;
        long[] arr = new long[len];
        int i = 0;
        long s = 0;
        for(int x : capacity) {
            s += x;
            arr[i] = s;
            i++;
        }

        int count = 0;
        for (int j = 0; j < len; j++) {
            for (int k = j+2; k < len; k++) {
                if(capacity[j] == capacity[k]) {
                    if(arr[k-1]-arr[j] == capacity[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static long countStableSubarray2(int[] capacity) {
        int len = capacity.length;
        long[] arr = new long[len];
        int i = 0;
        long s = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : capacity) {
            s += x;
            arr[i] = s;
            map.put(x, i);
            i++;
        }

        int count = 0;
        for (int j = 0; j < len; j++) {
            for (int k = j+2; k < len; k++) {
                if(capacity[j] == capacity[k]) {
                    if(arr[k-1]-arr[j] == capacity[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}