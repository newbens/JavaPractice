package shejimoshi.bridge;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.info();
        Computer cp = new Desktop(new Lenovo());
        cp.info() ;
        new HashMap<>();
    }
}
