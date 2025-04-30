package LeetCode;

public class KthFactor {
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));
    }
    static int kthFactor(int n, int k) {
        // ArrayList<Integer> li = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            int s = n % i;
            if(s == 0) {
                k--;
                if(k == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
