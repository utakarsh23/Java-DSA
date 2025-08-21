package CodeForces.R1052.Contest1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheCunningSellar {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            long ans = 0;
            int x = 0;

            while (n > 0) {
                int d = (int)(n % 3);
                ans += (long)d * fcx(x);
                n /= 3;
                x++;
            }
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }

    static long fcx(int x) {
        if (x == 0) {
            return 2;
        }
        return power(3, x + 1) + (long) x * power(3, x - 1);
    }

    static long power(long base, int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}