package CodeForces.R1052.Contest1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TheSecNo {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        long t = fs.nextLong();
        while (t-- > 0) {
            long n = fs.nextLong();
            List<Long> li = new ArrayList<>();
            long pow = 10;   // must be long

            while (1 + pow <= n) {
                long d = 1 + pow;
                if (n % d == 0) {
                    li.add(n / d);
                }
                pow *= 10;
            }

            if (li.isEmpty()) {
                out.append("0\n");
            } else {
                Collections.sort(li);
                out.append(li.size()).append("\n");
                for (long x : li) {
                    out.append(x).append(" ");
                }
                out.append("\n");
            }
        }
        System.out.print(out);
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
    }
}
