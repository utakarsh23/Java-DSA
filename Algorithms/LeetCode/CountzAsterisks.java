package LeetCode;

public class CountzAsterisks {
    public static void main(String[] args) {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        System.out.println(countAsterisks(s));
    }
    public static int countAsterisks(String s) {
        String[] ss = s.split("\\|");
        int c = 0;
        for (int i = 0; i < ss.length; i+=2) {
            c+= count(ss[i]);
        }
        return c;
    }
    public static int count(String s) {
        int counts = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                counts++;
            }
        }
        return counts;
    }
}
