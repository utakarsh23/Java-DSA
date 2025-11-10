package LeetCode2;

class LexioGraphicallySmallestStringAfterReverse {

    public static void main(String[] args) {
        System.out.println(lexSmallest("abba"));
    }

    public static String lexSmallest1(String s) {
        //approach pov, try to find the last smallest or first largest character, then swap to teh left from teh smallest, and right to the largest, check both.
        int len = s.length();
        char lsc = s.charAt(0);
        int lsci = 0;
        char flc = s.charAt(len-1);
        int flci = 0;
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) <= lsc) {
                lsc = s.charAt(i);
                lsci = i;
            }
        }
        for(int i = len-2; i >= 0; i--) {
            if(s.charAt(i) >= flc) {
                flc = s.charAt(i);
                flci = i;
            }
        }
        String a = new StringBuilder(s.substring(0, lsci+1)).reverse().append(s, lsci+1, len).toString();
        String b = s.substring(0, flci) + new StringBuilder(s.substring(flci, len)).reverse();
        return a.compareTo(b) >= 0 ? b : a;
    }

    static boolean compare(String a, String b) {
        int i = 0;
        int len = a.length();
        while(i < len) {
            if(a.charAt(i) < b.charAt(i)) {
                return true;
            } else if(a.charAt(i) > b.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static String lexSmallest(String s) {
        int i = 0;
        int len = s.length();
        String t = s;
        for(i = 0; i < len; i++) {
            String a = new StringBuilder(s.substring(0, i+1)).reverse().append(s, i+1, len).toString();
            String b = s.substring(0, i) + new StringBuilder(s.substring(i, len)).reverse();
            a = a.compareTo(b) > 0 ? b : a;
            t = t.compareTo(a) > 0 ? a : t;
        }
        return t;
    }
}