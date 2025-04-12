package LeetCode;

class ifAcomesBefB {
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(checkString(s));
    }
    static boolean checkString(String s) {
        int i = s.length()-1;
        while(i > 0) {
            if(s.charAt(i) < s.charAt(i-1)) {
                return false;
            }
                i--;
        }
        return true;
    }
}