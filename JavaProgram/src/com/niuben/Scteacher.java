package com.niuben;
//会唱歌的厨子是个好老师
public class Scteacher extends Person1 implements Cooking,Singing{
    String course;
    public void setInfo(String name,int age,boolean sex,String course) {
        super.name = name;
        super.age = age;
        super.sex = sex;
        this.course = course;

    }
    @Override
    public void fry() {
        System.out.println(super.name+"老师拿手的菜是炒菜。");

    }

    @Override
    public void sing() {
        System.out.println(super.name+"拿手的歌是夜的第七章。");
    }

    @Override
    public void showInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.sex);
        System.out.println(this.course);

    }
}