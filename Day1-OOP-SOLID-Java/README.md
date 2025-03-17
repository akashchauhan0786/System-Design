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
**Benefit:** Easier to maintain and understand. Improves modularity and makes testing simpler. Changes in one responsibility won't affect other parts of the class, reducing bugs.  

#### 🔴 Problem without SRP:
```java
class Invoice {
    private String details;

    public void calculateTotal() {
        // calculation logic
    }

    public void printInvoice() {
        // print logic
    }

    public void saveToDB() {
        // DB save logic
    }
}
```
✅ Here, `Invoice` class is handling **calculation**, **printing**, and **data persistence**—multiple responsibilities. Any change in print/save logic would affect this class.

#### ✅ Solution using SRP:
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

class InvoiceRepository {
    public void save(Invoice invoice) {
        // save to DB logic
    }
}
```
➡ Now each class has **only one reason to change**, making the code clean, modular, and easier to maintain.

**How it helps:**
- Encourages separation of concerns.
- Makes the code easier to understand, test, and refactor.
- Enhances maintainability in the long term.

**[View Java Code → SOLID/SRP.java](./SOLID/SRP.java)******
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
**Benefit:** Enables you to add new features without modifying existing code, reducing risk of breaking existing functionality.

#### 🔴 Problem without OCP:
```java
class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.radius * c.radius;
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        }
        return 0;
    }
}
```
✅ Adding a new shape (like `Rectangle`) will require modifying `AreaCalculator`, which violates OCP.

#### ✅ Solution using OCP:
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

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
```
➡ Now we can add new shapes without touching `AreaCalculator`, following OCP.

**How it helps:**
- Supports scalability and future extensions.
- Reduces bugs by not altering existing, working code.

**[View Java Code → SOLID/OCP.java](./SOLID/OCP.java)****
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
**Benefit:** Avoids unexpected behavior in code reuse, ensures correctness through inheritance.

#### 🔴 Problem violating LSP:
```java
class Bird {
    public void fly() {
        System.out.println("Bird can fly");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}
```
✅ Ostrich is a bird but can't fly — substituting Ostrich breaks the behavior expected from Bird.

#### ✅ Solution following LSP:
```java
interface Bird {}

interface FlyableBird extends Bird {
    void fly();
}

class Sparrow implements FlyableBird {
    public void fly() {
        System.out.println("Sparrow flies");
    }
}

class Ostrich implements Bird {
    // no fly method here, so no broken behavior
}
```
➡ Now we avoid misuse of subclassing and preserve correct behavior.

**How it helps:**
- Promotes accurate hierarchy and safer code reuse.
- Avoids runtime failures due to unexpected subclass behavior.

**[View Java Code → SOLID/LSP.java](./SOLID/LSP.java)****
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
**Benefit:** Leads to cleaner and more modular code.

#### 🔴 Problem violating ISP:
```java
interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {
    public void print() { System.out.println("Printing"); }
    public void scan() { throw new UnsupportedOperationException(); }
    public void fax() { throw new UnsupportedOperationException(); }
}
```
✅ OldPrinter only prints, but still has to implement unnecessary methods.

#### ✅ Solution following ISP:
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class BasicPrinter implements Printer {
    public void print() {
        System.out.println("Printing");
    }
}

class AllInOnePrinter implements Printer, Scanner {
    public void print() { System.out.println("Printing"); }
    public void scan() { System.out.println("Scanning"); }
}
```
➡ Now each class implements only the methods it needs.

**How it helps:**
- Keeps interfaces focused and minimal.
- Encourages composition over bloated abstractions.

**[View Java Code → SOLID/ISP.java](./SOLID/ISP.java)****
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
**Benefit:** Reduces tight coupling between software components.

#### 🔴 Problem violating DIP:
```java
class MechanicalKeyboard {
    public void type() {
        System.out.println("Typing on Mechanical Keyboard");
    }
}

class Computer {
    MechanicalKeyboard keyboard = new MechanicalKeyboard();

    public void input() {
        keyboard.type();
    }
}
```
✅ Computer is tightly coupled with MechanicalKeyboard — can't switch easily.

#### ✅ Solution following DIP:
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
➡ Now we can swap any Keyboard implementation without touching `Computer`.

**How it helps:**
- Promotes flexibility and testing via dependency injection.
- Encourages abstraction and reduces direct dependency.

**[View Java Code → SOLID/DIP.java](./SOLID/DIP.java)****
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
