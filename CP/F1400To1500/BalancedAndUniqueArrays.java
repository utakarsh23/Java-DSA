package F1400To1500;

import java.io.PrintWriter;

class BalancedAndUniqueArrays
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            int n = ni();
            long[] left = new long[n/2];
            long[] right = new long[n/2];
            if((n/2)%2 != 0) pn("NO");
            else {
                int si = 1;
                int ei = n;
                for(int i = 1; i < n/2; i++) {
                    left[i-1] = si;
                    left[n/2-i] = ei;
                    si++;
                    ei--;
                    right[i-1] = si;
                    right[n/2-i] = ei;
                    si++;
                    ei--;
                }
                pn("YES");
                for(int i = 0; i < n/2; i++) {
                    p(left[i] + " ");
                }
                pn("");
                for(int i = 0; i < n/2; i++) {
                    p(right[i] + " ");
                }
            }
            

        
        }
        out.flush();
	}
	
	// 1 10 2 9 3 8 4 7 5 6 
    // 1 10 3 8 5 6 : 1 3 5 6 8 10
    // 2 9 4 7      : 2 4 7 9
    
    //1 12 3 10 5 8, 13 : 52 : 1 3 5 8 10 12 13
    //2 11 4 9  6 7, 14 : 53 : 2 4 6 7 9  11 14
	// 1 2 3 4
	// 1 4 -> 
	// 2 3 
	
	// 6 
	// 1 6 3
	// 2 5 4
	
	//8 
	//1 8 3 6 -> 1 3 6 8 
	//2 7 4 5 -> 2 4 5 7 
	
	//10 
	//1 10 3 8 5
	//2 9  4 7 6
	
	//12 
	//1 12 3 10 5 8
	//2 11 4 9  6 7
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new BalancedAndUniqueArrays().solve();}
	
	FastReader in; PrintWriter out;
	BalancedAndUniqueArrays() {
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