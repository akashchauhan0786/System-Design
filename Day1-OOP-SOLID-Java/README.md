# 📘 Day 1: OOP Recap + SOLID Principles in Java

> A beginner-friendly walkthrough of Object-Oriented Programming concepts and SOLID principles with Java examples. This README is part of a Low-Level Design (LLD) learning series.

---

## 🔁 Object-Oriented Programming (OOP) Concepts

### 1. **Encapsulation**
**Quick Summary:** Hides internal data by keeping fields private and exposing them via getters/setters.  
**[View Java Code → OOP/Encapsulation.java](./OOP/Encapsulation.java)**
```java
class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

### 2. **Abstraction**
**Quick Summary:** Show only necessary details to the user and hide complexity using abstract classes or interfaces.  
**[View Java Code → OOP/Abstraction.java](./OOP/Abstraction.java)**
```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}
```

### 3. **Inheritance**
**Quick Summary:** Allows a class to inherit fields and methods from another class.  
**[View Java Code → OOP/Inheritance.java](./OOP/Inheritance.java)**
```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
```

### 4. **Polymorphism**
**Quick Summary:** Allows multiple classes to implement the same method in different ways.  
**[View Java Code → OOP/Polymorphism.java](./OOP/Polymorphism.java)**
```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing square");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();

        shape1.draw(); // Drawing circle
        shape2.draw(); // Drawing square
    }
}
```

---

## 🔥 SOLID Principles

### 1. **Single Responsibility Principle (SRP)**
**Quick Summary:** A class should only have one reason to change—do one thing and do it well.  
**[View Java Code → SOLID/SRP.java](./SOLID/SRP.java)**
```java
class Invoice {
    private String details;
    public void calculateTotal() {
        // calculation logic
    }
}

class InvoicePrinter {
    public void print(Invoice invoice) {
        // print logic
    }
}
```

### 2. **Open/Closed Principle (OCP)**
**Quick Summary:** Classes should be open for extension, but closed for modification.  
**[View Java Code → SOLID/OCP.java](./SOLID/OCP.java)**
```java
interface Shape {
    double area();
}

class Circle implements Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    double side;
    public Square(double side) {
        this.side = side;
    }
    public double area() {
        return side * side;
    }
}
```

### 3. **Liskov Substitution Principle (LSP)**
**Quick Summary:** Derived classes must be completely substitutable for their base classes.  
**[View Java Code → SOLID/LSP.java](./SOLID/LSP.java)**
```java
class Bird {
    public void fly() {
        System.out.println("Bird can fly");
    }
}

class Sparrow extends Bird {}

// Wrong example: Ostrich cannot fly but inherits fly method
class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

// Better design: Separate interfaces
interface Flyable {
    void fly();
}

class Eagle implements Flyable {
    public void fly() {
        System.out.println("Eagle flies");
    }
}
```

### 4. **Interface Segregation Principle (ISP)**
**Quick Summary:** Clients should not be forced to depend on interfaces they do not use.  
**[View Java Code → SOLID/ISP.java](./SOLID/ISP.java)**
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class AllInOnePrinter implements Printer, Scanner {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }
}
```

### 5. **Dependency Inversion Principle (DIP)**
**Quick Summary:** High-level modules should not depend on low-level modules—both should depend on abstractions.  
**[View Java Code → SOLID/DIP.java](./SOLID/DIP.java)**
```java
interface Keyboard {
    void type();
}

class MechanicalKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing on Mechanical Keyboard");
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void input() {
        keyboard.type();
    }
}

public class Main {
    public static void main(String[] args) {
        Keyboard keyboard = new MechanicalKeyboard();
        Computer computer = new Computer(keyboard);
        computer.input();
    }
}
```

---
