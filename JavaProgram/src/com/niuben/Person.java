package com.niuben;

public class Person {
    private String name;   //成员变量    ALT+INSERT
    private int age;
    private boolean male;

//    public Person() {    //无参构造方法
//    }

    Person(String name, int age, boolean male) {      //全参构造
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public void show() {
        System.out.println("我叫" + this.name + "，是一个" + this.male + "，今年" + this.age + "岁。");
    }

}

