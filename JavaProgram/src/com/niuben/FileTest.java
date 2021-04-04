package com.niuben;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("E:\\IDEA\\FileTest.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        file.renameTo(new File("E:\\IDEA\\RE_FileTest.txt"));  //改名
        File file1 = new File("E:\\IDEA\\FileTest.txt");
        System.out.println(file1.exists()); //判断是否存在
        File file2 = new File("E:\\IDEA\\RE_FileTest.txt");
        System.out.println(file2.canRead()); //是否可读
        System.out.println(file2.canWrite());//是否可写
    }
}
