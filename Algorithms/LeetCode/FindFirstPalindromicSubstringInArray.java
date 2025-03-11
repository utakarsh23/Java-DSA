package LeetCode;

public class FindFirstPalindromicSubstringInArray {
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
    }
        static String firstPalindrome(String[] words) {
            for(String t : words) {
                if(palindrome(t)) {
                    return t;
                }
            }
            return "";
        }
        static Boolean palindrome(String s) {
            int i = 0;
            int j = s.length()-1;
            while(i <= j) {
                if(s.charAt(i) != s.charAt(j)) return false;
                i++; j--;
            }
            return true;
        }
}
