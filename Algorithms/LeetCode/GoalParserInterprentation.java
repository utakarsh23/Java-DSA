package LeetCode;

public class GoalParserInterprentation {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
    static public String interpret(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.toString().contains("()") || sb.toString().contains("(al)")) {
            if(sb.toString().contains("()")) {
                int i = sb.indexOf("()");
                sb.replace(i, i + 2, "o");
            }
            if(sb.toString().contains("(al)")) {
                int i = sb.indexOf("(al)");
                sb.replace(i, i + 4, "al");
            }
        }
        return sb.toString();
        //m2
//      return s.replace("()", "o").replace("(al)", "al");
    }
}
