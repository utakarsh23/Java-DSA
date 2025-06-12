package GFG;

class Pow {
    double power(double b, int e) {
        long exp = Math.abs((long)e);  // Use long to handle edge case of Integer.MIN_VALUE
        double result = 1.0;

        while (exp > 0) {
            if ((exp & 1) == 1) { // If the current bit is set (odd power)
                result *= b;
            }
            b *= b;
            exp >>= 1; // Divide exponent by 2
        }

        return (e < 0) ? 1.0 / result : result;
    }
}