package Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i < 100000; i++) {
//            if(palin(i)) {
//                list.add(i);
//            }
//        }
        System.out.println(generatePalin(100000));
    }

    static boolean palin(int n) {
        int temp = n;
        int ans = 0;
        while (n != 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n /= 10;
        }
        return ans == temp;
    }

    static List<Integer> generatePalin(int n) {
        int size = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            StringBuilder s = new StringBuilder().append(i);
            if(i < 10) {
                list.add(Integer.parseInt(s.toString()));
                list.add(Integer.parseInt(s.append(s).toString()));
            } else {
                String t = new StringBuilder(s).deleteCharAt(s.length() - 1).reverse().toString();
                s.append(t);
                list.add(Integer.parseInt(s.toString()));
                s.insert(s.length() / 2, s.charAt(s.length() / 2));
                list.add(Integer.parseInt(s.toString()));
            }
        }
        Collections.sort(list);
        return list;
    }
}