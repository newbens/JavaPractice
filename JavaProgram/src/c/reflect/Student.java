package c.reflect;

public class Student extends Person implements study, move {
    String school;
    private String grade;

    public Student() {
        System.out.println("调用的是无参构造");
    }

    public Student(String school) {
        System.out.println("调用的是有参构造");
        this.school = school;
    }

    private Student(String name, int age) {
        System.out.println("调用的是私有构造");
        this.name = name;
        this.age = age;
    }

    @Override
    public void studying() {
        System.out.println("学习");
    }

    @Override
    public void moving() {
        System.out.println("骑自行车");
    }

    public void showInfo() {
        System.out.println("我叫" + this.name + ",今年" + this.age + "岁，学校是" + this.school);
    }

    public void showInfo(String school) {      //重载
        System.out.println("这是showInfo的重载方法");
        System.out.println("我叫" + this.name + ",今年" + this.age + "岁，学校是" + this.school);
    }

    private void test(String name) {
        this.name = name;
        System.out.println("调用private方法 "+this.name);
    }

    public String getSchool() {
        return school;
    }

}
