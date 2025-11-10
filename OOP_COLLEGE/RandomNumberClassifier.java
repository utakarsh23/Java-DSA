import java.util.*;

class NumberSet {
    int[] nums;
    NumberSet(int size) {
        nums = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) nums[i] = r.nextInt(201) - 100;
    }
}

class PositiveEven implements Runnable {
    int[] arr;
    PositiveEven(int[] arr) { this.arr = arr; }
    public void run() {
        System.out.print("Positive Even: ");
        for (int n : arr) if (n > 0 && n % 2 == 0) System.out.print(n + " ");
        System.out.println();
    }
}

class PositiveOdd implements Runnable {
    int[] arr;
    PositiveOdd(int[] arr) { this.arr = arr; }
    public void run() {
        System.out.print("Positive Odd: ");
        for (int n : arr) if (n > 0 && n % 2 != 0) System.out.print(n + " ");
        System.out.println();
    }
}

class Negative implements Runnable {
    int[] arr;
    Negative(int[] arr) { this.arr = arr; }
    public void run() {
        System.out.print("Negative: ");
        for (int n : arr) if (n < 0) System.out.print(n + " ");
        System.out.println();
    }
}

public class RandomNumberClassifier {
    public static void main(String[] args) {
        NumberSet ns = new NumberSet(15);
        System.out.println("Generated Numbers: " + Arrays.toString(ns.nums));
        Thread t1 = new Thread(new PositiveEven(ns.nums));
        Thread t2 = new Thread(new PositiveOdd(ns.nums));
        Thread t3 = new Thread(new Negative(ns.nums));
        t1.start(); t2.start(); t3.start();
    }
}