package c.reflect;

public class Person {
    String name;
    int age;
    @Deprecated
    public void get() {
        System.out.println("����");
    }

    public void get2() {
        get();
    }
}
