package CodeForces.R1052.Contest1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneToInfinity {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextInt();
            long sum = 0;
            long digitsUsed = 0;
            long num = 1;

            while (digitsUsed < n) {
                String s = Long.toString(num);
                for (int j = 0; j < s.length() && digitsUsed < n; j++) {
                    sum += s.charAt(j) - '0';
                    digitsUsed++;
                }
                num++;
            }
            out.append(sum).append("\n");
        }
        System.out.println(out);
    }

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

        long nextLong() throws IOException { return Long.parseLong(next()); }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}
