package com.niuben;

import java.io.File;

public class FilePrint {
    public static void main(String[] args) {
        File file = new File("E:\\6、Django爱鲜蜂项目第一天");
        new FilePrint().printFile(file);

    }

    public void printFile(File file) {
        if (file.isFile()) {
            System.out.println(file.getAbsoluteFile());
        } else {
            File[] fs = file.listFiles(); //获取文件夹下的所有
            for (File f : fs) {
                printFile(f);     //递归
            }
        }
    }
}
