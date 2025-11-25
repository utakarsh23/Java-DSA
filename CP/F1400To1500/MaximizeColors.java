package F1400To1500;

import java.io.PrintWriter;

class MaximizeColors
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            long n = 3;
            long[] nums = nll(n);
            int ans = 0;
            for(int i = 0; i < 3; i++) {
                if(nums[i] >= 1) {
                    ans++;
                    nums[i]--;
                }
            }
            for(int i = 0; i < 3; i++) {
                for(int j = i+1; j < 3; j++) {
                    if(nums[i] >= 1 && nums[j] >= 1) {
                        ans++;
                        nums[i]--;
                        nums[j]--;
                    }
                }
            }
            pn(ans);
        
        }
        out.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new MaximizeColors().solve();}
	
	FastReader in; PrintWriter out;
    MaximizeColors() {
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
