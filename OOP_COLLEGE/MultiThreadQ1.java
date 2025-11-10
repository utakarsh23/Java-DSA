import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random rand = new Random();
        while (true) {
            int num = rand.nextInt(100);
            System.out.println("\nGenerated Number: " + num);

            if (num % 2 == 0) {
                new Square(num).start();
            } else {
                new Cube(num).start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Square extends Thread {
    private int number;
    Square(int n) {
        number = n;
    }

    public void run() {
        System.out.println("Square of " + number + " = " + (number * number));
    }
}

class Cube extends Thread {
    private int number;
    Cube(int n) {
        number = n;
    }

    public void run() {
        System.out.println("Cube of " + number + " = " + (number * number * number));
    }
}

public class MultiThreadQ1 {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        generator.start();
    }
}