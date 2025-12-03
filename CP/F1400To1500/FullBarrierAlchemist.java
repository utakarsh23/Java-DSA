package F1400To1500;

import java.io.PrintWriter;

class FullBarrierAlchemist
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            int n = ni();
            long h = nl();
            long tuck = nl();
            long jump = nl();
            long life = nl();
            long[][] nums = new long[n][2];
            for(int i = 0; i < n; i++) {
                nums[i][0] = nl();
                nums[i][1] = nl();
            }
            // if type 1 -> h - tuck || nums[_][0]
            // if type 2 -> h + jump || 
            int i = 0;
            for(i = 0; i < n; i++) {
                if(checkOne(nums[i][0])) {
                    if(h - tuck <= nums[i][1]) continue;
                    else if(h - tuck > nums[i][1] && life > 1) life--;
                    else break;
                } else {
                    if(jump >= nums[i][1]) continue;
                    else if(jump < nums[i][1] && life > 1) life--;
                    else break;
                }
            }
            pn(i);
        
        }
        out.flush();
	}
	
	boolean checkOne(long x) {
	    return x == 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new FullBarrierAlchemist().solve();}
	
	FastReader in; PrintWriter out;
	FullBarrierAlchemist() {
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