package day_one;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.故障现象
 *  Exception in thread "9" java.util.ConcurrentModificationException 并发修改异常
 * 2.导致原因
 *  当一个线程在修改时，另一个线程也在修改
 * 3.解决方法
 *   1.使用Vector
 *   2.Collections.synchronizedList(new ArrayList<>());
 *   3.CopyOnWriteArrayList<>();
 * 4.优化建议
 */


public class NotSafe {
    public static void main(String[] args) {
        mapNotSafe();
        setNotSafe();
        listNotSafe();
    }

    /**
     * HashMap底层是数组加链表加红黑树，默认大小16，每次扩容1倍。
     */
    private static void mapNotSafe() {
        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 30 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    /**
     *   HashSet的底层是HashMap
     *   HashSet是单值，是怎么实现的
     *      return map.put(e, PRESENT)==null; 添加的values为一个object类型的常量。
     */
    private static void setNotSafe() {
        Set<String> set = new ConcurrentSkipListSet<>();
        new HashSet<>();
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    /**
     * arraylist 底层实现是数组。默认大小10，每次扩容一半
     */
    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
