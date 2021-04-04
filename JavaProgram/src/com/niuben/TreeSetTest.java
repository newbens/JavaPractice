package com.niuben;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet<>(); //Treeset必须存放相同类型的数据
//        set.add(5);
//        set.add(2);
//        set.add(7);
//        set.add(9);
//        Iterator it = set.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        for (Object object : set) {
//            System.out.print(object);
//        }
//        set.remove(5);//删除
//        System.out.println(set);
//        boolean x = set.contains(9); //判断是否在集合内
//        System.out.println(x);
//        set.clear();//清空
//        System.out.println(set);
        Person3 p1 = new Person3("张三", 23);
        Person3 p2 = new Person3("张思", 24);
        Person3 p3= new Person3("张武", 23);
        Person3 p4= new Person3("张柳", 25);
        Set<Person3> set = new TreeSet<>(new Person3());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        for (Person3 p : set) {
            System.out.println(p.name+" "+p.age);
        }

    }
}

class Person3 implements Comparator<Person3>    {
    String name;
    int age;
    public Person3() {
    }

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person3 o1, Person3 o2) {
        if (o1.age >= o2.age){
            return 1;
        } else{
            return -1;
        }
    }
}
