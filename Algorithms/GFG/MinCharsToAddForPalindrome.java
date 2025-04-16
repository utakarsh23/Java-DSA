package GFG;

public class MinCharsToAddForPalindrome {
    public static void main(String[] args) {

    }
    public static int minChar(String s) {
        // Write your code here
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String concat = s+"#"+rev;

        int[] lps = new int[concat.length()];
        int len = 0;
        int i = 1;
        while(i < concat.length()) {
            if(concat.charAt(i) == concat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len -1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.length() - lps[concat.length()-1];
        // int i = 0;
        // int j = s.length()-1;
        // int trim = j;
        // int res = 0;

        // while(i < j) {
        //     if(s.charAt(i) == s.charAt(j)) {
        //         i++;
        //         j--;
        //     } else {
        //         res++;
        //         i = 0;
        //         j = --trim;
        //     }
        // }
        // return res;
    }
}
