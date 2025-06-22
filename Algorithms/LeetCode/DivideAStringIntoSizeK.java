package LeetCode;

import java.util.Arrays;

class DivideAStringIntoSizeK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghijkl", 13, 'x')));
    }
    public static String[] divideString(String s, int k, char fill) {
        int x = Math.floorDiv(s.length(), k);
        String[] str = new String[Math.ceilDiv(s.length(), k)];
        int a = 0;
        int i;
        for(i = 0; i < x; i ++) {
            str[i] = s.substring(a, a+k);
            a+=k;
        }
        int temp = i;
        if(a < s.length()) {
            StringBuilder sBuilder = new StringBuilder(s.substring(a));
            for (i = 0; i < k- s.substring(a).length(); i++) {
                sBuilder.append(fill);
            }
            str[temp] = sBuilder.toString();
        }
        return str;
    }
}