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

interface Flyable {
    void fly();
}

class Eagle implements Flyable {
    public void fly() {
        System.out.println("Eagle flies");
    }
}
