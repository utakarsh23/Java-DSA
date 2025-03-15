package Recursion.Strings;

public class ParameterCheck {
    public static void main(String[] args) {
        System.out.println("length " + calcCount("ABCDE", 0));
    }

    private static int calcCount(String string, int count) {
        if(string.length() == 0) {
            return count;
        }
        System.out.println("C : " + count);
        String rs = string.substring(1);
        return calcCount(rs, count +=1);
    }
}
