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
