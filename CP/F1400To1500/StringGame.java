package F1400To1500;

import java.util.Scanner;

public class StringGame {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


//        while(t-- > 0) {
//            int n = input.nextInt();
//            String s = input.next();
//
//            StringBuilder sb = new StringBuilder(s);
//            int f = sb.indexOf("10");
//            int c = 0;
//            while(f != -1) {
//                sb.replace(f, f + 2, "");
//                f = sb.indexOf("10");
//                c++;
//            }
//            int r = sb.indexOf("01");
//            while(r != -1) {
//                sb.replace(r, r + 2, "");
//                r = sb.indexOf("01");
//                c++;
//            }
//            System.out.println(c % 2 == 0 ? "Ramos" : "Zlatan");
//        }

        while(t-- > 0) {
            int n = input.nextInt();
            String s = input.next();
            int c = 0;
            int c0 = 0;
            int c1 = 0;
            for (int i = 0; i < n; i++) {
                if(s.charAt(i) == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }
            c = Math.min(c0, c1);
            System.out.println(c % 2 == 0 ? "Ramos" : "Zlatan");
        }


        // (1 (1 0) 0) (1 0) (1 0) - 4
        //  (1 (1 0) (0 1) 0) (1 0) - 4
        // (1 (1 0) (0 (1 0) 1) 0) - 4

        // 1 0 1 1 1 1 1 0 0 1 0 1 0
        // (1 0) 1 1 1 (1 (1 0) 0) (1 0) (1 0) - 5
        // 1 (0 1) 1 (1 (1 (1 0) 0) 1 0) (1 0) - 5
        // (1 0) 1 1 1 (1 (1 0) (0 1) 0) (1 0) - 5
        //

        // 1 0 1 1 1 1 1 0 0 1 0 0 0 0 1 0 0


    }
}
