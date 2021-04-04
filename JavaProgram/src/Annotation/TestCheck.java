package Annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/*
    ���Կ��
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculate c = new Calculate();
        //��ȡ�ֽ����ļ�����
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();
        int num = 0;  //��¼�쳣���ֵĴ���
        BufferedWriter bw = new BufferedWriter(new FileWriter("BUG.txt"));
        for (Method method : methods) {
            //�жϷ����Ƿ���ע��
            if (method.isAnnotationPresent(Check.class)) {
                //�о�ִ�У�
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //�����쳣
                    num ++;
                    bw.write("������ "+method.getName()+"���쳣��");
                    bw.newLine();
                    bw.write("�쳣�����ƣ�"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("�쳣��ԭ��"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("******************************************");
                }
            }
        }
        bw.write("����һ������"+num+"��yic");
        bw.flush();
        bw.close();
    }
}
