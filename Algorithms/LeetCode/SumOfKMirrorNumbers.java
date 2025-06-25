package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        System.out.println(kMirror(7, 17));
    }

    //brute force method;
    static public long kMirror(int k, int n) {
//        return palindromes(k, n);
        long sum = 0;
        List<Long> li = generatePalins(n, k);
        Collections.sort(li);
        for (long x : li) {
//            if(palinBasek(x, k)) {
                sum += x;
                n--;
//            }
            if(n == 0) break;
        }
        return sum;
    }
    static int palindromes(int k, int n) {
        // List<Integer> list = new ArrayList<>();
        int i = 1;
        int sum = 0;
        while(n > 0) {
            if(palinBase10(i) && palinBasek(i, k)) {
                n--;
                sum += i;
            }
            i++;
        }
        return sum;
    }
    static boolean palinBase10(int x) {
        StringBuilder s = new StringBuilder(x+"");
        s.reverse();
        return s.toString().equals(x+"");
    }


    static boolean palinBasek(long x, int k) {
        String s = Integer.toString((int) x, k);
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.contentEquals(sb);
    }

    //better method
    static List<Long> generatePalins(int n, int k) { //to generate palindromes;
        n = n * 2;
        List<Long> palins = new ArrayList<>();
        int i = 1;
        while(palins.size() <= n) {
            String s = Integer.toString(i);
            String rev = new StringBuffer(s.substring(0, s.length()-1)).reverse().toString();
            long oddPalin = Integer.parseInt(s+rev);
            if(palinBasek(oddPalin, k))
                palins.add(oddPalin);
            if(palins.size() == n) break;

            rev = new StringBuffer(s).reverse().toString();
            long evenPalin = Integer.parseInt(s + rev);
            if(palinBasek(evenPalin, k))
                palins.add(evenPalin);
            i++;
        }
        return palins;
    }


    //optimal

    static long kMirror1(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            List<Long> palins = generatePalindromes(length);
            for (long pal : palins) {
                if (palinBasek(pal, k)) {
                    sum += pal;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }

        return sum;
    }


    static List<Long> generatePalindromes(int length) {
        List<Long> result = new ArrayList<>();
        int halfLen = (length + 1) / 2;
        int start = (int) Math.pow(10, halfLen - 1);
        int end = (int) Math.pow(10, halfLen);

        for (int i = start; i < end; i++) {
            String left = Integer.toString(i);
            String right = new StringBuilder(left.substring(0, length % 2 == 0 ? left.length() : left.length() - 1)).reverse().toString();
            long pal = Long.parseLong(left + right);
            result.add(pal);
        }

        return result;
    }
}
