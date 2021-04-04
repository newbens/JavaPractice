package c.reflect;

public class Person {
    String name;
    int age;
    @Deprecated
    public void get() {
        System.out.println("¹ıÆÚ");
    }

    public void get2() {
        get();
    }
}
