class Bird {
    public void fly() {
        System.out.println("Bird can fly");
    }
}

class Sparrow extends Bird {}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

class Bird {
    void eat() {}
}

class FlyingBird extends Bird {
    void fly() {}
}

class Sparrow extends FlyingBird {}
class Ostrich extends Bird {}  // Ostrich has no fly method
