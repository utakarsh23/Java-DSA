package OneThousandToFourteen100;

import java.util.Scanner;

public class Two {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        //single n
        while(t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int temp = m;
            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                m = m - x >= 0 ? m - x : m;
                if(temp == m) System.out.print(0);
                else System.out.print(1);
                temp = m;
            }
            System.out.println();
        }

    }
}
