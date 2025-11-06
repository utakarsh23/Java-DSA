package F1400To1500;

import java.util.Scanner;

//https://www.codechef.com/practice/course/2-star-difficulty-problems/DIFF1500/problems/AVGPERM?tab=statement
public class AveragePermutation {
    /*
    Theory :

-----------
    n-2
      E (pi + p(i+1) + p(i+2))/3
    1
-----------

    Pattern :
    Sp = (p1 + p2 + p3)/3 + (p2 + p3 + p4)/3 + (p3 + p4 + p5)/3 .... (p(n-3) + p(n-2) + p(n-1))/3 + (p(n-2) + p(n-1) + p(n))/3;
    Sp = (p1 + 2(p2) + 3(p3 + p4 + .. + pn-2) + 2p(n-1) + pn)/3
    Points :
        1 -> instead of arranging all the permutation why don't we focus on what's given in teh question ?(the sum of permutations)

        2 -> sp shows 3 parts
            ø : p1 & pn >>> single without any constant
            ø : p2 & p(n-1) >>> with the constant 2*
            ø : p3 ... p(n-2) >>> with the constant 3*

        3 -> to notice ? No constant should be the biggest ones at the position (1):P1 & (n):P(n) and with constant 2 should be the largest ones
            followed by the ones((2):P2 & (n-1):P(n-1)) & then with remaining with constant 3(the biggest constant) the minimums should be in here.

        eg : n = 8;
            1 2 3 4 5 6 7 8 >>>>> 8 ... 7  ---  8 6 ... 5 7  ---   8 6 4 ... 3 5 7  ---   8 6 4 2 1 3 5 7
            ths is how the patten will be considered.
            now if we try the sum.
            1 2 3 4 5 6 7 8 >>>>> 8 ... 7  ---  8 2*6 ... 2*5 7  ---   8 2*6 3*(4 ... 3) 2*5 7  ---   8 2*6 3*(4 2 1 3) 2*5 7
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        // 1 2 3 4
        // 4 2 1 3
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int j = n;
            int k = j-1;
            while(j > 0) {
                System.out.print(j + " ");
                j -= 2;
            }
            j = n % 2 == 0 ? 1 : 2;
            while(j < n) {
                System.out.print(j + " ");
                j += 2;
            }
            System.out.println();
        }
    }
}
