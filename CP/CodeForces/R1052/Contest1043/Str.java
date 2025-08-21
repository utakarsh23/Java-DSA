package CodeForces.R1052.Contest1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Str {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String a = fs.next();
            int m = fs.nextInt();
            String b = fs.next();
            String c = fs.next();
            StringBuilder sb = new StringBuilder(a);
            for (int k = 0; k < m; k++) {
                if(c.charAt(k) == 'V') {
                    sb.insert(0, b.charAt(k));
                } else {
                    sb.append(b.charAt(k));
                }
            }
            out.append(sb).append("\n");
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

        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}
