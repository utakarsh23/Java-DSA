package TLE31;

import java.io.*;
import java.util.*;

public class HalloumiBoxes {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

            if (k == 1) {
                int[] arr1 = Arrays.copyOf(arr, n);
                Arrays.sort(arr1);
                if (Arrays.equals(arr, arr1)) out.append("YES\n");
                else out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }
        System.out.print(out);
    }

    // Fast input reader (skips blank lines automatically)
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}