package LeetCode;

import java.util.Arrays;

class SortingTheSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
    static String sortSentence(String s) {
        String[] str = s.split("\\s");
        String[] arr = new String[str.length];
        for (String x: str) {
            int position = x.charAt(x.length()-1)-'0'-1;
            arr[position] = x.substring(0, x.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for(String t: arr) {
            sb.append(t + " ");
        }
        return sb.toString().trim();
    }
}