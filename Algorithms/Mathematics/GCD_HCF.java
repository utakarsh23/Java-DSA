package Mathematics;

public class GCD_HCF {
    public static void main(String[] args) {
        System.out.println(gcd(17, 95));
    }

    //euclidean algorithm
    // a > b > 0
    //GCD(a,b) • LCM(a,b) = ab.
    static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}
