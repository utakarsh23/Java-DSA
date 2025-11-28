package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class STL {

    //input
    static class In {
        BufferedReader br;
        StringTokenizer st;
        In() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }


    //output
    static PrintWriter out = new PrintWriter(System.out);


    //pairs
    static public class Pair<U, V> {
        U first; V second;
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }


    //array actions
    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }


    //frequencies & counting
    static void freq(int[] arr, Map<Integer, Integer> map) {
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    static void freqChars(String s, Map<Character, Integer> map) {
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    static void freqWords(String s, Map<String, Integer> map) {
        for(String x : s.split("\\s+")) {
            map.put(x.trim(), map.getOrDefault(x, 0) + 1);
        }
    }


    //sieves & prime no's
    static List<Integer> sieveList(int n) {
        int[] arr = sieveArray(n);
        List<Integer> li = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(arr[i] == 1) {
                li.add(i);
            }
        }
        return li;
    }

    static int[] sieveArray(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        arr[0] = arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(arr[i] == 1) {
                for (int j = i * i; j <= n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //swaps n stuffs
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void swap(StringBuilder sb, int a, int b) {
        char c = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, c);
    }

    static String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        swap(sb, a, b);
        return sb.toString();
    }

    static void reverse(int[] arr) {
        int i = 0;
        while (i < arr.length/2) {
            swap(arr, i, arr.length-1-i);
            i++;
        }
    }

    //Maths
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }

    static int lcm(int a, int b) { return a / gcd(a, b) * b; }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }


    //prefix sum
    static long[] prefixSum(int[] arr) {
        long[] pre = new long[arr.length];
        for (int i = 0; i < arr.length-1; i++) {
            pre[i+1] = pre[i] + arr[i];
        }
        return pre;
    }

}
