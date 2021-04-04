package Annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/*
    测试框架
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculate c = new Calculate();
        //获取字节码文件对象
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();
        int num = 0;  //记录异常出现的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("BUG.txt"));
        for (Method method : methods) {
            //判断方法是否有注解
            if (method.isAnnotationPresent(Check.class)) {
                //有就执行！
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常
                    num ++;
                    bw.write("方法： "+method.getName()+"出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("******************************************");
                }
            }
        }
        bw.write("本次一共出现"+num+"次yic");
        bw.flush();
        bw.close();
    }
}
