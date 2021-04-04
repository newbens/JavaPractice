package com.niuben;

public class Student extends Person {
    public Student(String name, int age, boolean male, String school) {
        super(name, age, male);
        this.school = school;
    }

    String school;

    public static void main(String[] args) {
        Student s = new Student("牛犇",20,true,"乡村大学");
        s.show();
        System.out.println(s.toString());
    }

    @Override
    public void show() {   //重写父类方法快捷键 ctrl+o；
        super.show();  //父类show方法
        System.out.printf("来自%s大学",this.school);
    }

}
