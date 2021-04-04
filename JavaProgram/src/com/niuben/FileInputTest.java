package com.niuben;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputTest {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream in = new FileInputStream("E:\\IDEA\\test\\RE_FileTest.txt");
            byte[] a = new byte[2];
            in.read(a);
            System.out.println(new String(a));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
