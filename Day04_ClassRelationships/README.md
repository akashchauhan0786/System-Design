# Day 4: Class Relationships in Low-Level Design

Understanding the different types of class relationships is crucial to building well-structured, modular, and maintainable systems. Today, we will cover the major types of class relationships used in object-oriented programming and how to identify and implement them correctly.

---

## 🔗 Types of Class Relationships

### 1. **Association**
- Describes a "uses-a" relationship.
- Represents a general connection between two classes.
- Example: A `Teacher` uses a `Student` class to teach.

```java
class Teacher {
    Student student;
}
```

### 2. **Aggregation** (Has-A relationship)
- A special form of association.
- Represents a whole-part relationship where the part can exist independently.
- Example: A `Department` has `Professors`, but professors can exist without the department.

```java
class Professor {}

class Department {
    List<Professor> professors;
}
```

### 3. **Composition** (Strong Has-A relationship)
- A form of aggregation with strong ownership.
- If the container is destroyed, contained objects are also destroyed.
- Example: A `Library` contains `Books`. If the library is closed, books are destroyed.

```java
class Book {}

class Library {
    private List<Book> books = new ArrayList<>();
}
```

### 4. **Inheritance** (IS-A relationship)
- Indicates a subclass inherits from a superclass.
- Enables reuse and polymorphism.
- Example: A `Dog` is a type of `Animal`.

```java
class Animal {}

class Dog extends Animal {}
```

### 5. **Dependency**
- A class depends on another class temporarily to perform a task.
- Example: A `ShoppingCart` uses `PaymentService` during checkout.

```java
class PaymentService {}

class ShoppingCart {
    void checkout(PaymentService paymentService) {
        // use paymentService
    }
}
```

---

## 📌 Summary Table

| Relationship  | Description                   | Lifespan Dependency   | Example Class Pair     |
|---------------|-------------------------------|------------------------|--------------------------|
| Association   | Uses-a                        | Independent            | Teacher → Student       |
| Aggregation   | Has-a (loose)                 | Part independent       | Department → Professor  |
| Composition   | Has-a (strong ownership)      | Part dies with whole   | Library → Book          |
| Inheritance   | Is-a                          | Child inherits parent  | Dog → Animal            |
| Dependency    | Temporary usage               | Short-term             | ShoppingCart → PaymentService |

---

## 🧠 Tips
- Use **inheritance** only when IS-A truly makes sense.
- Prefer **composition over inheritance** for flexibility.
- Always identify if the relationship is weak (association/dependency) or strong (composition/aggregation).
- Think of the **lifespan and ownership** when choosing between aggregation and composition.

---

Next up: Day 5 – Class Design Principles (SOLID).
