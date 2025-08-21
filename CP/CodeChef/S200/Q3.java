package CodeChef.S200;

import java.util.Scanner;

public class Q3 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        //single n
        while(t-- > 0) {
            int n = input.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char ch = (char)('a' + (i % 3));
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
