package com.niuben;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
        System.out.println(list.get(2));


        //指定位置插入单个数据
        list.add(1, "2");
        System.out.println(list);

        //指定位置插入另一个数组
        List<String> list1 = new ArrayList<>();
        list1.add("3");
        list1.add("4");
        list.addAll(2, list1);
        System.out.println(list);

        //获取元素下标
        System.out.println(list.indexOf("2"));  //第一次出现的位置
        list.add("2");
        System.out.println(list.lastIndexOf("2"));//最后一次的位置

        //按指定下标修改元素
        list.set(5, "kobe");
        System.out.println(list);

        //截取 和python中的切片相同
        List<String> list2 = list.subList(3, 6);
        System.out.println(list2);

    }
}
