package com.niuben;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(2);
        set.add(5);
        set.add(6);
        set.add(7);
        System.out.println(set);
        //遍历1  迭代器遍历
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //遍历2
        for (Object object:set) {
            System.out.print(object+",");
        }
        Set<String> set1 = new HashSet<>(); //指定泛型


    }
}
