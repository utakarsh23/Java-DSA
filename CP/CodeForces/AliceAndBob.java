package CodeForces;

import java.util.Scanner;

public class AliceAndBob {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        System.out.println(TwoFrogs(t));
    }
    static StringBuilder TwoFrogs(int t){
        Scanner input = new Scanner(System.in);
        StringBuilder ss = new StringBuilder();
        while (t-- > 0){
            int n = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            if(Math.abs(a-b) == 1) {
                ss.append("No\n");
            } else {
                int aliceDist = Math.min(a-1, n-a);
                int bobDist = Math.min(b-1, n-b);

                if(aliceDist <= bobDist) {
                    ss.append("YES\n");
                } else {
                    ss.append("NO\n");
                }
            }
        }
        return ss;
    }
}
