package Randoms;

abstract class Vehicle {
    public abstract void startEngine();

    public void fuelType(String type) {
        System.out.println("Fuel type: " + type);
    }
}

class Car extends Vehicle {
    public void startEngine() {
        System.out.println("Car engine started with a key.");
    }
}

class Bike extends Vehicle {
    public void startEngine() {
        System.out.println("Bike engine started with self-start.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.startEngine();
        v1.fuelType("Petrol");

        Vehicle v2 = new Bike();
        v2.startEngine();
        v2.fuelType("Petrol");
    }
}