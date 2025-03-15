package Recursion;
//when a function is being executed it is stored inside the stack memory, until it finishes execution.
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci1(6));

    }

    //recursion
    static Integer fibonacci(int n) {
        if(n < 2) {
            return n;
        }
        return fibonacci(n-1) +  fibonacci(n-2);
    }

    static Integer fibonacci1(int n) {
        if(n < 2) return n;
        int i = 1;
        int p = 1;
        int fibo = 0;
        for (int j = 2; j < n; j++) {
            fibo = i + p;
            p = i;
            i = fibo;
        }
        return fibo;
    }

}
