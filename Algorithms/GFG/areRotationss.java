package GFG;

class areRotationss {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        String comb = s1 + s1;
        return search(comb, s2);
    }
    public static boolean search(String pat, String txt) {
        int[] lps = computeLPSArray(pat);
        int i= 0, j = 0;
        while(i < txt.length()) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
                if(j == pat.length()) return true;
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if(len != 0) {
                    len = lps[len -1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}