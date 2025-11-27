package F1400To1500;

import java.io.PrintWriter;

class Equality
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            long n = nl();
            long[] nums = new long[(int)n];
            long sum = 0;
            for(int i = 0; i < n; i++) {
                nums[i] = nl();
                sum += nums[i];
            }
            long sumx = sum/(n-1);
            for(int i = 0; i < n; i++) {
                p(sumx - nums[i] + " ");
            }
            pn("");

        
        }
        out.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new Equality().solve();}
	
	FastReader in; PrintWriter out;
	Equality() {
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
