package F1400To1500;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class FitToPlay
{
    
	void solve() throws Exception {
        long t = nl();
        while(t-- > 0) {
            int n = ni();
            long[] arr = nll(n);
            long[] mins = new long[n];
            long min = arr[0];
            int k = 0;
            for(long x : arr) {
                min = Math.min(min, x);
                mins[k++] = min;
            }

            long max = Integer.MIN_VALUE;
            for(int i = 1; i < n; i++) {
                max = Math.max(max, arr[i]-mins[i]);
            }


            if(max <= 0) pn("UNFIT");
            else pn(max);

        }
        out.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new FitToPlay().solve();}
	
	FastReader in; PrintWriter out;
	FitToPlay() {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }
    void p(Object o) { out.print(o); }
    void pn(Object o) { out.println(o); }
    void pni(Object o) { out.println(o); out.flush(); }
    String ns() throws Exception { return in.next(); }
    String nsln() throws Exception { return in.nextLine(); }
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}
    long[] nll(long n) throws Exception {
        long[] a = new long[(int)n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }
    int[] nii(int n) throws Exception {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }
}