package LeetCode;

public class PrimePalindromes {
    public static void main(String[] args) {
        System.out.println(primePalindrime(8));
    }

    //brute force
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

    static int primePalindrime(int n) {
        if (n <= 2) return 2;
        for (int i = n; i < 12; i++) {
            if (isPalin(i) && isPrime(i)) return i;
        }
        for (int len = 1; len < 6; len++) {

            for (int root = (int)Math.pow(10, len - 1); root < (int)Math.pow(10, len); root++) {
                String left = Integer.toString(root);
                String right = new StringBuilder(left.substring(0, left.length() - 1)).reverse().toString();
                int cand = Integer.parseInt(left + right);
                if (cand >= n && isPrime(cand)) {
                    return cand;
                }
            }
        }

        return 100030001;
    }
}
