package LeetCode;

public class ConvertToBaseNegativeTwo {
    public static void main(String[] args) {
        System.out.println(baseNeg2(7));
    }
    static public String baseNeg2(int n) {
        if (n == 0) return "0";

        StringBuilder result = new StringBuilder();

        while (n != 0) {
            int remainder = n % -2;

            if (remainder < 0) {
                remainder += 2;
                n = (n / -2);
                n++;
            } else {
                n = n / -2;
            }

            result.append(remainder);
        }

        return result.reverse().toString();
    }
}
