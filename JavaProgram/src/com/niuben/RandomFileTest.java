package com.niuben;

import java.io.RandomAccessFile;
//   随机读取
public class RandomFileTest {
    public static void main(String[] args) throws Exception {
//            TestRandomRead();
            RandomWrite();
    }

    public static void TestRandomRead() throws Exception {
        //有两个参数 一是文件路径，二是方式（访问模式）
        RandomAccessFile ra = new RandomAccessFile("E:\\IDEA\\test\\RandomFileTest.txt","r");
        ra.seek(16); //设置读取起始点
        byte[] a = new byte[1024];
        int len = 0;
        while ((len = ra.read(a)) != -1) {
            System.out.println(new String(a,0,len));
        }
    }

    public static void RandomWrite() throws Exception{
        RandomAccessFile ra = new RandomAccessFile("E:\\IDEA\\test\\RandomFileTest.txt","rw");
        ra.seek(12);
       // ra.seek(ra.length());  //代表文件的追加
        ra.write("你好中国 ".getBytes());
        ra.close();
    }
}
