package F1400To1500;

import java.util.Scanner;

public class BellaCiao {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        while(t-- > 0) {
            int D = input.nextInt(); //no of hijacking days
            int d = input.nextInt(); //no of d(days) for rate to increase
            int P = input.nextInt(); //no of rate to be produced
            int Q = input.nextInt(); //no of rate to be incteased in d days
            int x = D/d;


            int li = 0;
            int ans = d*P;
            int i = 0;
            for (i = d; i < D; i+=d) {
                P += Q;
                ans += d * P;
            }
            ans += (D-i)*P;
            System.out.println(ans);
        }

    }
}
