package F1400To1500;

import java.io.PrintWriter;

class ParallelProcessing
{
    
	void solve() throws Exception {
	    long t = nl();
        while(t-- > 0) {
            int n = ni();
            long[] nums = nll(n);
            // Arrays.sort(nums);
            // long p1 = nums[n-1];
            // long p2 = n == 1 ? 0 : nums[n-2];
            // int j = n-3;
            // while(j >= 0) {
            //     if(nums[j] + p1 > nums[j] + p2) {
            //         p2 += nums[j];
            //     } else {
            //         p1 += nums[j];
            //     }
            //     j--;
            // }
            // pn(Math.max(p1, p2));
            long sum = 0;
            for(long x : nums) {
                sum += x;
            }
            
            long minTime = sum;
            long currSum = 0;
            for(long x : nums) {
                currSum += x;
                long otherSum = sum - currSum;
                long maxOfTwo = Math.max(currSum, otherSum);
                minTime = Math.min(minTime, maxOfTwo);
            }
            pn(minTime);
        
        }
        out.flush();
	}
	// 2 3 4 5
	// 5 -> 0 -> 2 :7
	// 4 -> 3 -> 0 :7
	
	// 2 3 4 
	// 4 -> 0 :4
	// 3 -> 2 :5
	
	// 1 1 1 1 1 1 
	// 1 -> 0 -> 1 -> 0 -> 1 :3
	// 1 -> 1 -> 0 -> 1 -> 0 :3
	
	// 2 3 4 5 7
	// 7 -> 0 -> 3 -> 0 :10
	// 5 -> 4 -> 0 -> 2 :9
	
	// 5 9 2 
	// 5 -> 2 :7
	// 9 -> 0 :9
	
	// 2 3 7 11
	// 11 -> 0 -> 0
	// 7  -> 3 -> 2
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	public static void main (String[] args) throws java.lang.Exception { new ParallelProcessing().solve();}
	
	FastReader in; PrintWriter out;
	ParallelProcessing() {
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