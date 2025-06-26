package LeetCode;

public class PrimePalindromes {
    public static void main(String[] args) {
        System.out.println(primePalindrome(9989900));
    }
    static int primePalindrome(int n) {
        int i = n;
        while(true) {
            if(isPrime(i) && isPalin(i)) {
                break;
            }
            i++;
        }
        return i;
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    static boolean isPalin(int n) {
        String s = Integer.toString(n);
        String sb = new StringBuilder(s).reverse().toString();
        return s.equals(sb);

    }
}
