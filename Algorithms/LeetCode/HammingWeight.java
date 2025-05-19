package LeetCode;

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(7));
    }
    static int hammingWeight(int n) {
        int result = 0;
        for(int i= 0; i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                result += 1;
            }
        }
        return result;
    }
}
