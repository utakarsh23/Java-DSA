package LeetCode;

import static java.lang.Float.NaN;
import static java.lang.Float.POSITIVE_INFINITY;

class powXY {
    public static void main(String[] args) {
//        System.out.println(myPow1(2, -20000));
        double x = Double.POSITIVE_INFINITY;
        System.out.println(Float.isNaN((float) (0.0/0.0)));
    }

    //m1
    static double myPow(double x, int n) {
        if(n < 0) {
            return (1/x)*myPow(x, ++n);
        }
        if(n == 0) {
            return 1;
        }
        return x*myPow(x, --n);
    }

    //m2
    static double myPow1(double x, int n) {
        return myPowLong(x, (long)n);
    }
    static double myPowLong(double x, long n) {
        if(n < 0) {
            return (1.0)/myPowLong(x, -n);
        }
        if(n == 0) {
            return 1;
        }
        if(n%2 == 1) {
            return x * myPowLong(x*x, (n-1)/2);
        } else {
            return myPowLong(x*x, n/2);
        }
        // return x*myPowLong(x, --n);
    }


}