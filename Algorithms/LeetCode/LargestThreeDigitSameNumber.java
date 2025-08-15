package LeetCode;

public class LargestThreeDigitSameNumber {
    public static void main(String[] args) {
        int x = 3;
        int num = 52;
        String s = String.valueOf(num);
        for (int i = 0; i < x; i++) {
            s+=num;
        }
        System.out.println(s);
    }
}
