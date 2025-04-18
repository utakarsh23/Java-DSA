package GFG;

import java.util.ArrayList;

public class StringROtations {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcda";
        System.out.println(areRotations1(s1, s2));

    }
    static boolean areRotations(String s1, String s2) {
        ArrayList<String> li = new ArrayList<>(s1.length());
        String temp = s2;
        for (int i = 0; i < s1.length(); i++) {
            s2 = s2.charAt(s2.length()-1)+s2.substring(0, s2.length()-1);
            temp = temp.substring(1, s2.length())+temp.charAt(0);

            if(li.contains(temp) || li.contains(s2)) {
                return true;
            }
            li.add(s2);
            li.add(temp);
        }
        return false;
    }
    static boolean areRotations1(String s1, String s2) {
        String t = s1 + s1;
        return (t).contains(s2);
    }
}
