package Randoms;

class Parent {
    String name = "Parent";

    Parent() {
        System.out.println("Parent constructor called");
    }

    void showMessage() {
        System.out.println("Hello from Parent class");
    }
}

class Child extends Parent {
    String name = "Child";

    Child() {
        super();
        System.out.println("Child constructor called");
    }

    void display() {
        System.out.println("Child name = " + name);

        System.out.println("Parent name = " + super.name);

        super.showMessage();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}