package com.niuben;

public class EnumTest {
    public static void main(String[] args) {
        Season season = Season.SPRING; //此处不用new对象，直接.SPRING相当于构造对象
        season.showInfo();
        Season season1 = Season.SPRING;
        boolean b = (season==season1);
        System.out.println(b);
    }
}
enum Season{    //枚举构造类    单例模型
    SPRING("春天","春意盎然"),  //此处想到于调用有参构造
    SUMMER("夏天","炎炎夏日"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","寒风凛冽");
    private final String name;
    private final  String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;

    }

    public void showInfo() {
        System.out.println(this.name+"  "+this.desc);
    }
}