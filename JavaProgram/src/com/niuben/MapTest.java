package com.niuben;

import java.util.*;

public class MapTest {   //和python中的字典基本一致
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 97);
        map.put("b", 98);
        map.put("c", 98);
        map.put("d", 99);
        map.put("e", 100);
        System.out.println(map);
        map.remove("a");
        System.out.println(map);

        //遍历
        Set<String> set = map.keySet();  //先获取map中key的值，存入set
        for (String key : set) {        //遍历key，通过key获得values
            System.out.println(key + " " + map.get(key));
        }

        //遍历2
        Set<Map.Entry<String, Integer>> set1 = map.entrySet();
        for (Map.Entry<String, Integer> en : set1) {
            System.out.println(en);
            System.out.println(en.getKey()+"   "+en.getValue());
        }


        //TreeMap
        //按照key进行排序 如果key是字符按照阿ASCLL排序
        Map<Integer, String> map1 = new TreeMap<>();
        map1.put(4, "f");
        map1.put(3, "f");
        map1.put(1, "f");
        map1.put(2, "f");
        System.out.println(map1);
        Map<Integer, String> map2 = new LinkedHashMap<>();
        map2.put(4, "f");
        map2.put(3, "f");
        map2.put(1, "f");
        map2.put(2, "f");
        System.out.println(map2);

    }
}
