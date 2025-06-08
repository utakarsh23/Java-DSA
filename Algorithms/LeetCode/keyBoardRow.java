package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class keyBoardRow {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(findWords(words));
    }
    static List<String> findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        for(String t : words) {
            String s = t;
            s = s.toLowerCase();
            int[] arr = new int[s.length()];
            for(int i = 0; i < s.length(); i++) {
                if(row1.indexOf(s.charAt(i)) >= 0) {
                    arr[i] = 1;
                    continue;
                }
                if(row2.indexOf(s.charAt(i)) >= 0) {
                    arr[i] = 2;
                    continue;
                }
                if(row3.indexOf(s.charAt(i)) >= 0) {
                    arr[i] = 3;
                }
            }
            int i = 1;
            for(i = 1; i < arr.length; i++) {
                if(arr[i-1] != arr[i]) {
                    break;
                }
            }
            if(i == s.length()) {
                ans.add(t);
            }
            if(i < s.length() && arr[i] == arr[i-1]) {
                ans.add(t);
            }
         }
        return ans;
    }
}