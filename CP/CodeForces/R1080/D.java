package CodeForces.R1080;

import F1400To1500.FastReader;

import java.io.*;
import java.util.*;
import java.lang.*;


public class D {

    void solve() throws Exception {
        long t = nl();
        while (t-- > 0) {
            int n = ni();
            long[] f = nll(n);
            long[] a = new long[n];

            //the formula 2ai = f(i-1) + f(i+1) - 2f(i)
            for (int i = 1; i < n - 1; i++) {
                a[i] = (f[i - 1] + f[i + 1] - 2 * f[i]) / 2;
            }


            long sf = 0;
            for (int j = 1; j < n - 1; j++) {
                sf += a[j] * (n - 1 - j);
            }
            a[0] = (f[n - 1] - sf) / (n - 1);

            long sl = 0;
            for (int j = 1; j < n - 1; j++) {
                sl += a[j] * j;
            }
            a[n - 1] = (f[0] - sl) / (n - 1);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }
            pn(sb.toString());
        }
        out.flush();
    }


    public static void main(String[] args) throws Exception {
        new D().solve();
    }

    FastReader in;
    PrintWriter out;

    D() {
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

//
//class FastReader {
//    BufferedReader br;
//    StringTokenizer st;
//
//    public FastReader() {
//        br = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    public FastReader(String s) throws Exception {
//        br = new BufferedReader(new FileReader(s));
//    }
//
//    public String next() throws Exception {
//        while (st == null || !st.hasMoreElements()) {
//            try {
//                st = new StringTokenizer(br.readLine());
//            } catch (IOException e) {
//                throw new Exception(e.toString());
//            }
//        }
//        return st.nextToken();
//    }
//
//    public String nextLine() throws Exception {
//        String str = "";
//        try {
//            str = br.readLine();
//        } catch (IOException e) {
//            throw new Exception(e.toString());
//        }
//        return str;
//    }
//}
