package CodeForces.R1080;

import F1400To1500.FastReader;

import java.io.*;
import java.util.*;
import java.lang.*;


public class A {

    void solve() throws Exception {
        int t = ni();
        while (t-- > 0) {
            int n = ni();
            int[] a = nii(n);

            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                int x = i;
                while ((x & 1) == 0) x >>= 1;

                int y = a[i - 1];
                while ((y & 1) == 0) y >>= 1;

                if (x != y) {
                    ok = false;
                    break;
                }
            }

            pn(ok ? "YES" : "NO");
        }
    }

public static void main(String[] args) throws Exception {
    new A().solve();
}

FastReader in;
PrintWriter out;

A() {
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
//
//class FastReader{
//    BufferedReader br;
//    StringTokenizer st;
//    public FastReader(){
//        br = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    public FastReader(String s) throws Exception{
//        br = new BufferedReader(new FileReader(s));
//    }
//
//    public String next() throws Exception{
//        while (st == null || !st.hasMoreElements()){
//            try{
//                st = new StringTokenizer(br.readLine());
//            }catch (IOException e){
//                throw new Exception(e.toString());
//            }
//        }
//        return st.nextToken();
//    }
//
//    public String nextLine() throws Exception{
//        String str = "";
//        try{
//            str = br.readLine();
//        }catch (IOException e){
//            throw new Exception(e.toString());
//        }
//        return str;
//    }
//}
