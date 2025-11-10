package F1400To1500;

import java.util.*;
import java.io.*;
class CHFHEIST{
	//SOLUTION BEGIN
	void pre() throws Exception{}
	void solve(int TC) throws Exception{
	    long D = nl(), d = nl(), P = nl(), Q = nl();
	    long rem = D%d;
	    long N = D/d;
	    long sum = d * apSum(P, Q, N);
	    sum += rem * nth(P, Q, N+1);
	    pn(sum);
	}
	long apSum(long a, long d, long n){
	    return (n*(2*a+(n-1)*d))/2;
	}
	long nth(long a, long d, long n){
	    return a+(n-1)*d;
	}
	//SOLUTION END
	void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
	static boolean multipleTC = true;
	FastReader in;PrintWriter out;
	void run() throws Exception{
	    in = new FastReader();
	    out = new PrintWriter(System.out);
		int T = (multipleTC)?ni():1;
	    pre();for(int t = 1; t<= T; t++)solve(t);
	    out.flush();
	    out.close();
	}
	public static void main(String[] args) throws Exception{
	    new CHFHEIST().run();
	}
	int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
	void p(Object o){out.print(o);}
	void pn(Object o){out.println(o);}
	void pni(Object o){out.println(o);out.flush();}
	String n()throws Exception{return in.next();}
	String nln()throws Exception{return in.nextLine();}
	int ni()throws Exception{return Integer.parseInt(in.next());}
	long nl()throws Exception{return Long.parseLong(in.next());}
	double nd()throws Exception{return Double.parseDouble(in.next());}

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
}