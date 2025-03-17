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
