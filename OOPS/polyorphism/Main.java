package polyorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();


        System.out.println(circle.thisExample());
        circle.area();
        System.out.println();
    }

}
