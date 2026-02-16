package CodeForces.R1080;

import F1400To1500.FastReader;

import java.io.*;
import java.util.*;
import java.lang.*;


public class C {

    void solve() throws Exception {
        int t = ni();
        while (t-- > 0) {
            int n = ni();
            int[] a = nii(n);

            int INF = 1_000_000_000;


            int[] dp = new int[7];
            int[] nextDp = new int[7];

            for (int v = 1; v <= 6; v++) {
                dp[v] = (a[0] == v ? 0 : 1);
            }

            for (int i = 1; i < n; i++) {
                Arrays.fill(nextDp, INF);

                for (int v = 1; v <= 6; v++) {
                    int cost = (a[i] == v ? 0 : 1);

                    for (int u = 1; u <= 6; u++) {
                        if (u != v && u + v != 7) {
                            if (dp[u] != INF) {
                                nextDp[v] = Math.min(nextDp[v], dp[u] + cost);
                            }
                        }
                    }
                }

                System.arraycopy(nextDp, 0, dp, 0, 7);
            }

            int ans = INF;
            for (int v = 1; v <= 6; v++) {
                ans = Math.min(ans, dp[v]);
            }

            pn(ans);
        }
    }


public static void main(String[] args) throws Exception {
    new C().solve();
}

FastReader in;
PrintWriter out;

C() {
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
