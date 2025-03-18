# 📚 Day 2 – Interface, Abstract Class, IS-A vs HAS-A

---

## ✅ Topics Covered
- Interface in Java
- Abstract Class in Java
- Interface vs Abstract Class – Key Differences
- IS-A Relationship (Inheritance)
- HAS-A Relationship (Composition)

---

## 🔍 1. Interface in Java
- Interface is a contract that a class agrees to follow.
- All methods are abstract by default (till Java 7).
- From Java 8 onwards, interfaces can have `default` and `static` methods too.

### 🔸 Example:
```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
```

---

## 🔍 2. Abstract Class in Java
- Abstract class is a class that cannot be instantiated.
- It can have both abstract (unimplemented) and concrete (implemented) methods.
- Used when you want to provide a common base with some default behavior.

### 🔸 Example:
```java
abstract class Vehicle {
    int speed;

    abstract void start();

    void displaySpeed() {
        System.out.println("Speed: " + speed);
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}
```

---

## 🔍 3. Interface vs Abstract Class – Key Differences

| Feature | Interface | Abstract Class |
|--------|------------|----------------|
| Inheritance | Implements | Extends |
| Multiple Inheritance | ✅ Supported | ❌ Not Supported |
| Method Types | Abstract, Default, Static | Abstract + Concrete |
| Variables | `public static final` | Instance variables allowed |
| Constructors | ❌ Not allowed | ✅ Allowed |
| Use Case | Define contract | Shared base class |

---

## 🔍 4. IS-A vs HAS-A Relationship in OOP

### ➤ IS-A Relationship → **Inheritance**
- IS-A denotes **inheritance** between classes.
- Used to express **"is a type of"** relationship.
- Represented by **extends (class)** or **implements (interface)**.

#### 🔸 Example:
```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

// Dog IS-A Animal
```

#### 📌 Real-life Examples:
- Car IS-A Vehicle
- Dog IS-A Animal
- Circle IS-A Shape

---

### ➤ HAS-A Relationship → **Composition / Aggregation**
- HAS-A denotes that one class contains a reference to another class.
- Used to express **"has a"** relationship.
- Implemented via class composition.

#### 🔸 Example:
```java
class Engine {
    void start() {
        System.out.println("Engine starts");
    }
}

class Car {
    Engine engine = new Engine();

    void startCar() {
        engine.start();
        System.out.println("Car is running");
    }
}

// Car HAS-A Engine
```

#### 📌 Real-life Examples:
- Car HAS-A Engine
- Student HAS-A Pen
- Driver HAS-A License

---

## 🧠 Practice Problems

1. **Shape Interface Design**
   - Create `Shape` interface → Implement classes: `Circle`, `Rectangle`, `Triangle`.

2. **Abstract Class for Vehicles**
   - Create `Vehicle` abstract class → Extend with `Car`, `Bike`, `Truck`.

3. **IS-A and HAS-A Modeling**
   - Design classes:
     - `Driver HAS-A License`
     - `Engine HAS-A FuelTank`
     - `Car IS-A Vehicle` and `Car HAS-A Engine`

---

## 📘 Additional Reading:
- [Interface vs Abstract Class – Baeldung](https://www.baeldung.com/java-abstract-class-vs-interface)
- [IS-A vs HAS-A – GeeksForGeeks](https://www.geeksforgeeks.org/difference-between-is-a-and-has-a-relationship-in-java/)

---

## 🎥 Video Resources:
- [Interface vs Abstract Class – CodeWithHarry (Hindi)](https://www.youtube.com/watch?v=s1Rj3zt6lTg)
- [IS-A vs HAS-A – Telusko](https://www.youtube.com/watch?v=UdI1GaaU4Qg)

---

✅ **Tasks:**
- Draw UML class diagrams for all practice problems.
- Write Java code for IS-A and HAS-A relationships.
- Document key takeaways in your notes.
