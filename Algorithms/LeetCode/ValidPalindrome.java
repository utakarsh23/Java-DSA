package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class
ValidPalindrome {
    public static void main(String args[]) {
        System.out.println(isPalindromee("A man, a plan, a canal: Panama"));
    }
    static boolean isPalindrome(String s) {
        int i = 0;
        s = s.toLowerCase().trim();
        List<Character> ch = new ArrayList<>();
        int j = s.length()-1;
        int l = 0;
        if(s.length() < 2) {
            return true;
        }
        for (int k = 0; k < 26; k++) {
            ch.add((char)(65+k));
            ch.add((char)(97+k));
            if(l < 10) {
                ch.add((char) ('0' + l));
                l++;
            }
        }
        while(i < j) {
            while (i < j && !ch.contains(s.charAt(i))) {
                i++;
            }
            while (i < j && !ch.contains(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindromee(String s) {
        int i = 0 , j = s.length()-1;
        while(i<j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!((c1 >= 'A' && c1 <='Z') || (c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1<='9') )){
                i++;
                continue;
            }
            if(!((c2 >= 'A' && c2 <='Z') || (c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2<='9') )){
                j--;
                continue;
            }
            if(c1>='A' && c1 <='Z'){
                c1 += 32;
            }
            if(c2>='A' && c2 <='Z'){
                c2 += 32;
            }
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

