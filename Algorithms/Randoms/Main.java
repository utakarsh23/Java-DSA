package Randoms;

//import dorkbox.systemTray.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 70;
        long start = System.nanoTime();
        System.out.println(fibo1(n));
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start)/1_000_000.0 + " ms");


        long start1 = System.nanoTime();
        System.out.println(fibo(n));
        long end1 = System.nanoTime();
        System.out.println("Execution time: " + (end1 - start1)/1_000_000.0 + " ms");
    }

    static int fibo(int x) {
        if(x <= 1) {
            return 1;
        }
        if(map.containsKey(x)) {
            return map.get(x);
        }
        int ans = fibo(x-1) + fibo(x-2);
        map.put(x, ans);
        return ans;
    }

    static int fibo1(int x) {
        if(x <= 1) {
            return 1;
        }
        return fibo(x-1) + fibo(x-2);
    }
}