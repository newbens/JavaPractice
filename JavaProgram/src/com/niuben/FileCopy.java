package com.niuben;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) {
            Copy("E:\\悟空\\gg.gif","E:\\IDEA");
    }

    public static void Copy(String path, String copypath) {
        try {
            FileInputStream in = new FileInputStream(path);
            FileOutputStream out = new FileOutputStream(copypath);
            byte[] b = new byte[100];
            int len = 0;
            while ((len = in.read(b)) != -1) {   //边读边写
                out.write(b, 0, len);
            }
            out.flush();  // 将数据刷入硬盘
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("复制失败");
            System.out.println(e.getCause());
        }
        System.out.println("复制成功！");
    }
}
