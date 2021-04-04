package com.niuben;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws Exception{
//      WriteTxt();
        Compare();

    }

    public static void WriteTxt() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);  //InputStreamReader实现字节流到字符流的转换
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\IDEA\\RE_FileTest.txt"));
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            bw.write(line);
        }
        bw.flush();
        bw.close();
        br.close();
        is.close();
    }

    public static int Compare() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IDEA\\RE_FileTest.txt")));  //缓冲字符流读取
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in)); //读取
//        FileInputStream fi = new FileInputStream("E:\\IDEA\\RE_FileTest.txt");
        String line = "";
        String line2 = "";
        while ((line = br.readLine()) != null && (line2 = br2.readLine()) != null) {
            if (line2.equals(line)) {
                continue;
            }else{
                System.out.println("输入错误！");
                return -1;
            }
        }
        System.out.println("登陆成功！！！");

        br.close();
        br2.close();
        return 1;
    }
}
