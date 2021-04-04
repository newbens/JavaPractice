package com.niuben;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testSer();
        testDeser();
    }
    //对象的序列化
    public static void testSer() throws IOException {
        //定义对象输出流，把序列后的对象保存在文件中
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("E:\\IDEA\\object_test.txt"));
        Test2 t = new Test2();
        t.name = "TEST";
        o.writeObject(t);
        o.flush();  //把数据刷到硬盘
        o.close();
    }
    //对象的反序列化
    public static void testDeser() throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("E:\\IDEA\\object_test.txt"));
        Object object = o.readObject(); //读出后的对象为Object类型
        Test2 test2 = (Test2)object;  //将反序列化得到的object对象强转为想要的类型（大转小需要强转）
        System.out.println(test2.name);
        o.close();


    }
}
