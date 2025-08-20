package OneThousandToFourteen100;

import java.util.Scanner;

public class one {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        //single n
        while(t-- > 0) {
            int n = input.nextInt();
            String s = input.next();
            int count = 0;
            String vov = "aeiou";
            for(char c : s.toCharArray()) {

                if(vov.indexOf(c) >= 0) {
                    count = 0;
                } else {
                    count++;
                }
                if(count >= 4) {
                    System.out.println("NO");
                    break;
                }
            }
            System.out.println("Yes");
        }

    }
}
