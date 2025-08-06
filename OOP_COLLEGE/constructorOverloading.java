class Circle {
  double x, y, r;
  Circle() {
    x = 0; y = 0; r = 1;
  }
  Circle(double a, double b, double c) {
    x = a;
    y = b;
    r = c;
  }
  Circle(Circle c) {
    x = c.x;
    y = c.y;
    r = c.r;
  }

  Circle(double c) {
    x = 0; y = 0; r = c;
  }
  double displayArea() {
        return Math.PI * r * r;
  }

  double displayCirc() {
    return 2 * Math.PI * r;
  }
}


public class constructorOverloading {
  public static void main(String[] args) {
    Circle c1 = new Circle(0.0, 0.0, 5.0);
    Circle c2 = new Circle(c1);
    Circle c3 = new Circle(2.0);
    Circle c4 = new Circle();
    System.out.println(c1.displayCirc());
    System.out.println(c1.displayArea());
    System.out.println(c2.displayCirc());
    System.out.println(c2.displayArea());
    System.out.println(c3.displayCirc());
    System.out.println(c3.displayArea());
    System.out.println(c4.displayArea());
    System.out.println(c4.displayCirc());
  }
}
