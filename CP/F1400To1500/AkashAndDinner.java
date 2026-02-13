package F1400To1500;

import java.io.PrintWriter;
import java.util.*;
import java.lang.*;


public class AkashAndDinner {

    class Node {

        Node(long a, long b) {
            this.a = a;
            this.b = b;
        }
        long a; //category
        long b; //time
    }

    void solve() throws Exception {
        long t = nl();
        while(t-- > 0) {
            int n = ni();
            int k = ni();
            long[] ai = nll(n);
            long[] bi = nll(n);

            Node[] ans = new Node[n];
            for(int i = 0; i < n; i++) {
                ans[i] = new Node(ai[i], bi[i]);
            }
            Arrays.sort(ans, Comparator.comparingLong((Node ax) -> ax.b).thenComparingLong(ax -> ax.a));
            int i = 0;
            int l = 0;
            long sum = 0;

            Map<Long, Long> map = new HashMap<>(); //cat n time
            while(i < n && map.size() != k) {
                if(!map.containsKey(ans[i].a)) {
                    map.put(ans[i].a, ans[i].b);
                    sum += ans[i].b;
                }
                i++;
            }
            if(map.size() != k) sum = -1;

            pn(sum);


        }
        out.flush();
    }


    public static void main(String[] args) throws Exception {
        new AkashAndDinner().solve();
    }

    FastReader in;
    PrintWriter out;

    AkashAndDinner() {
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