package LeetCode2;

public class MaximumNumberofOperationsToMoveOnesToEnd {
    public static void main(String[] args) {
        String s = "10011010";
        System.out.println(maxOperations(s));
    }
    public static int maxOperations(String s) {
        // 0 0 1 1 1 0 1
        // i = 6, (index)
        // 0 0 0 1 1 1 1
        //--
        // 1 0 0 1 1 0 1
        // i = 6;
        // 0 0 0 1 1 1 1
        int c = 0;
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        int r = 0;
        int x = 0;
        for(int i = 0; i < len; i++) {
            while(i < len-1 && sb.charAt(i+1) == '0') {
                i++;
            }
            x = i;
            if(i < len && i != r) {
                c++;
                swap(sb, i, r);
                r = x;
            }
            while(i < len-1 && sb.charAt(i+1) == '1') {
                i++;
            }
            if(i - x > 0) {
                r = x;
            }
        }
        System.out.println(sb);
        return c;
    }
    static void swap(StringBuilder sb, int k, int i) {
        char c = sb.charAt(k);
        sb.setCharAt(k, sb.charAt(i));
        sb.setCharAt(i, c);
    }
}
