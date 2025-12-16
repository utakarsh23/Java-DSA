package CodeForces;


import F1400To1500.FastReader;

import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MakeItDivisibleBy25 {

    static String chs = "750025";
    void solve() throws Exception {
        long t = nl();
        while (t-- > 0) {
            long n = nl();
            String s = String.valueOf(n);
            int ans = Integer.MAX_VALUE;
            int len = s.length() - 1;
            for (int i = len; i > 0; i--) {
                char start = s.charAt(i);
                if(start != '5' && start != '0') continue;
                for (int j = i-1; j >= 0; j--) {
                    String ts = s.charAt(j) + "" + start;
                    if(chs.contains(ts)) {ans = Math.min(ans, i - j - 1 + (len - i)); break;}
                    if(i - j - 1 >= ans) break;
                }
            }
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            List<Integer> l1 = new ArrayList<>();
            l1.addAll(l);

            System.out.println(l1.equals(l));
            pn(ans);

        }
        out.flush();
    }


    //m2
    void solve1() throws Exception {
        long t = nl();
        while (t-- > 0) {
            long n = nl();
            String s = String.valueOf(n);
            int ans = Integer.MAX_VALUE;

            int len = s.length();
            int p0 = -1;
            int p5 = -1;
            for (int i = 0; i < len; i++) {

            }


            pn(ans);
        }
        out.flush();
    }







    public static void main(String[] args) throws Exception {
        new MakeItDivisibleBy25().solve();
    }

    FastReader in;
    PrintWriter out;

    MakeItDivisibleBy25() {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String ns() throws Exception {
        return in.next();
    }

    String nsln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    long[] nll(long n) throws Exception {
        long[] a = new long[(int) n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }

    int[] nii(int n) throws Exception {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }
}