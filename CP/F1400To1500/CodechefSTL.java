package F1400To1500;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            long n = nl();
            long[] nums = nll(n);

        
        }
        out.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new Codechef().solve();}
	
	FastReader in; PrintWriter out;
	Codechef() {
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


class FastReader{
	BufferedReader br;
    StringTokenizer st;
	    public FastReader(){
	    br = new BufferedReader(new InputStreamReader(System.in));
	 }

	 public FastReader(String s) throws Exception{
	     br = new BufferedReader(new FileReader(s));
	 }

	 String next() throws Exception{
	     while (st == null || !st.hasMoreElements()){
	         try{
	             st = new StringTokenizer(br.readLine());
	         }catch (IOException  e){
	             throw new Exception(e.toString());
	         }
	     }
	     return st.nextToken();
	 }

	 String nextLine() throws Exception{
	     String str = "";
	     try{   
	         str = br.readLine();
	     }catch (IOException e){
	         throw new Exception(e.toString());
	     }  
	     return str;
	 }
}
