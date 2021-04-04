package com.niuben;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        try {
            BufferedInputStreamTest();
            BufferOutTest();
            copyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void BufferedInputStreamTest() throws IOException {
        FileInputStream fileOutputStream = new FileInputStream("E:\\IDEA\\RE_FileTest.txt");
        BufferedInputStream br = new BufferedInputStream(fileOutputStream);  //放入缓冲
        byte[] b = new byte[10];
        int len = 0;
        while ((len = br.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
        //最晚开的最晚关
        br.close();
        fileOutputStream.close();
    }

    public static void BufferOutTest() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\IDEA\\fileOutputStreamTest.txt");
            BufferedOutputStream bo = new BufferedOutputStream(fileOutputStream); //缓冲
            String s = "BufferedOutputStreamTest";
            bo.write(s.getBytes());//写到内存里
            bo.flush();
            bo.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void copyFile() {
        try {
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream("E:\\IDEA\\fileOutputStreamTest.txt"));
            BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("E:\\IDEA\\JAVA\\fileOutputStreamTest.txt"));
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = bi.read(b)) != -1) {
                bo.write(b, 0, len);
            }
            bo.flush(); // 刷到内存中
            bo.close(); //最先关闭最晚开的
            bi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
