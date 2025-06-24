package LeetCode;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        System.out.println(kMirror(5, 20));
    }
    static public long kMirror(int k, int n) {
        return palindromes(k, n);
    }
    static int palindromes(int k, int n) {
        // List<Integer> list = new ArrayList<>();
        int i = 1;
        int sum = 0;
        while(n > 0) {
            if(palinBase10(i) && palinBasek(i, k)) {
                n--;
                sum += i;
            }
            i++;
        }
        return sum;
    }
    static boolean palinBase10(int x) {
        StringBuilder s = new StringBuilder(x+"");
        s.reverse();
        return s.toString().equals(x+"");
    }
    static boolean palinBasek(int x, int k) {
        String s = Integer.toString(x, k);
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.contentEquals(sb);
    }
}
