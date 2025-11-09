package day13;
// (JEP 409):
// Sealed class allowing only specific subclasses
sealed class Vehicle permits Car, Bike {
    public void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Permitted subclass [Child class has to be declared sealed, or explictly non sealed or fnal]
final class Car extends Vehicle {
    public void drive() {
        System.out.println("Car is driving...");
    }
}

// Permitted subclass [Child class has to be declared sealed, or explictly non sealed or fnal]
final class Bike extends Vehicle {
    public void ride() {
        System.out.println("Bike is riding...");
    }
}

// The following will cause a compilation error
// class Truck extends Vehicle {} // Not permitted!

public class SealedNonSealedTeseter {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // ✅ Allowed
        ((Car) car).drive(); // ✅ Allowed

        Vehicle bike = new Bike();
        bike.start(); // ✅ Allowed
        ((Bike) bike).ride(); // ✅ Allowed
    }
}