package TLE31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LaneTrip {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

            int maxGap = arr[0];
            for (int i = 1; i < n; i++) {
                maxGap = Math.max(maxGap, arr[i] - arr[i - 1]);
            }
            maxGap = Math.max(maxGap, 2 * (x - arr[n - 1]));

            out.append(maxGap).append("\n");
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

        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}