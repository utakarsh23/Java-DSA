package GFG;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams1(s1, s2));
    }
    static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int i = 0;
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        s1 = new String(ss1);
        s2 = new String(ss2);

        // while(i < ss1.length && i < ss2.length && ss1[i] == ss2[i]) {
        //     i++;
        // }
        // return i == ss1.length ? true : false;
        return s1.equals(s2);
    }

    public static boolean areAnagrams1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int i = 0;
        int k = 0;
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        for (int j = 0; j < ss1.length; j++) {
            i += ss1[j];
            k += ss2[j];
        }
        return i == k;
    }
}
