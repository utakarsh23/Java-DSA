package LeetCode;

public class ProcessStringWithSpecialOperationsI {
    public static void main(String[] args) {
        System.out.println(processStr("*z#"));
    }
    static public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if (s.charAt(i) == '*') {
                if(!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                i++;
            } else if (s.charAt(i) == '#') {
                i++;
                sb.append(sb);
            }else if (s.charAt(i) == '%') {
                i++;
                sb.reverse();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
