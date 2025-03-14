package LeetCode;

class isSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence1("abc","ahbgdc"));
    }
    static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() || j < t.length()) {
            while(i < s.length() && j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if(j == t.length() || i == s.length()) return false;
            i++; j++;
        }
        return true;
    }

    static boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}