package LeetCode;

public class toLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("hello"));
    }

    static public String toLowerCase(String s) {
        char[] ch = s.toCharArray();
        int len = s.length();
        for(int i = 0; i <len; i++) {
            if(ch[i] >= 65 && ch[i] <= 90) {
                ch[i]+= 32;
            }
        }
        return new String(ch);
    }
}
