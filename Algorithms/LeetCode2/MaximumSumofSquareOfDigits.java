package LeetCode2;

public class MaximumSumofSquareOfDigits {
    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(2, 3));
    }
    public static String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i < num; i++) {
            sb.append(9);
        }
        String s = String.valueOf(sum);
        StringBuilder ls = new StringBuilder(sb);
        String l = ls.deleteCharAt(sb.length() - 1).toString();
        while(sb.toString().compareTo(l) > 0) {
            if(digSum(sb.toString()).compareTo(l) > 0) {
                return sb.toString();
            }
            int len = sb.length()-1;
            if(sb.charAt(len) == '0') {
                while (sb.charAt(len) == '0') {
                    len--;
                }
                sb.setCharAt(len, (char)(sb.charAt(len)-'0'-1));
            } else {
                sb.setCharAt(len, (char)(sb.charAt(len)-'0'-1));
            }

        }
        return "";
    }
    static String digSum(String n) {
        int len = n.length()-1;
        StringBuilder ans = new StringBuilder();
        while(!n.isEmpty()) {
            ans.append(n.charAt(len--));
        }
        return ans.toString();
    }
}
