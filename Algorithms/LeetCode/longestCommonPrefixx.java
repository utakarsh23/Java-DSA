package LeetCode;

class longestCommonPrefixx {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    static String longestCommonPrefix(String[] strs) {
        int j = 0;
        StringBuilder sb = new StringBuilder(strs[0]);
        for(String s : strs) {
            int i = 0;
            if(j++ == 0) continue;
            while(i < s.length() && i < sb.length()) {
                while (i < s.length() && i < sb.length() && s.charAt(i) == sb.charAt(i)) {
                    i++;
                }
                sb = new StringBuilder(s.substring(0, i));
            }
        }
        return sb.toString();
    }
}