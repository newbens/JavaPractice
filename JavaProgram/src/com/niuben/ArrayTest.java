package com.niuben;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        // 1.打印数组
        int[] a = {1, 2, 3, 4, 5};
        String s = Arrays.toString(a);
        System.out.println(a);
        System.out.println(s);

        // 2.从数组创建一个 ArrayList
        String[] strings = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        System.out.println(arrayList);

        // 3.检查数组是否包含某一个值
        String[] strings2 = {"a", "b", "c", "d", "e"};
        boolean f = Arrays.asList(strings2).contains("a");
        System.out.println(f);

        // 4. 合并数组
//        String[] strings3 = {"!", "@", "#"};
//        String[] strings4 = {"$", "%", "^"};
//        String[] com =

        // 5.把数组中的元素用指定的分隔符连接起来
//        String j = StringUtils.join(new String[]{ "a", "b", "c" }, ", ");
//        System.out.println(j);

    }
}
