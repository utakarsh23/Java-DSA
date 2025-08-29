package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        System.out.println(kMirror2(2, 28));
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
//        int count = 0;
//        int length = 1;
//
//        while (count < n) {
//            List<Long> palins = generatePalindromes(length);
//            for (long pal : palins) {
//                if (palinBasek(pal, k)) {
//                    sum += pal;
//                    count++;
//                    if (count == n) break;
//                }
//            }
//            length++;
//        }

        List<Long> list = genPalins(n, k);
        for(Long x : list) {
            sum += x;
        }

        return sum;
//        return sum;
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


    /// /

    static List<Long> genPalins1s(int n, int k) {
        List<Long> list = new ArrayList<>();
        long i = 1;
        while (list.size() < n) {
            if (i < 10) {
                if (palinBaseK(i, k)) {
                    list.add(i);
                }
            } else {
                String t = String.valueOf(i) + new StringBuilder().append(i).reverse().deleteCharAt(0);
                long j = Long.parseLong(t);
                if (palinBaseK(j, k)) {
                    list.add(j);
                }
            }
            i++;
        }
        return list;
    }







    static List<Long> genPalins(int n, int k) {
        List<Long> list = new ArrayList<>();

        long[] allPalinlist = new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 32, 44, 55, 66, 77, 88, 99, 101};


        int i = 10;
        while (list.size() < n) {
            long l = allPalinlist[i % 10];
            if (palinBaseK(l, k)) {
                    list.add(l);
            }
            String t = String.valueOf(l) + new StringBuilder().append(l).reverse().deleteCharAt(0);
            long j = Long.parseLong(t);
            if (palinBaseK(j, k)) {
                list.add(j);
            }
            allPalinlist[i%10] = j;
            i++;
        }
        return list;
    }





    static boolean palinBaseK(long x, int k) {
        String s = Long.toString(x, k);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }


    static long kMirror2(int k, int n) {
        long sum = 0;
        List<Long> list = genPalins(n, k);
        for(Long x : list) {
            sum += x;
        }

        return sum;
    }

}
