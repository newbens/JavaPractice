package c.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("c.reflect.Student");
        Class superclazz = clazz.getSuperclass();  //获取父类 因为获取的父类也是一个类所以要用Class接受
        System.out.println("父类：" + superclazz.getName());
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("接口：" + c.getName());
        }
        Constructor[] constructors = clazz.getConstructors(); //获取公有构造方法
        for (Constructor con : constructors) {
            System.out.println("构造方法：" + con.getName());
            System.out.println("构造方法" + con.getName() + "的修饰符是" + con.getModifiers());
            Class[] paramList = con.getParameterTypes();  //获取构造方法的参数类型
            for (Class c : paramList) {
                System.out.println("构造方法：" + con.getName() + "的参数类型是" + c.getName());
            }
        }
        System.out.println("***********************************");
        Constructor[] constructors1 = clazz.getDeclaredConstructors();//获取类的所有构造方法
        for (Constructor con : constructors1) {
            System.out.println("构造方法：" + con.getName());
            System.out.println("构造方法" + con.getName() + "的修饰符是" + con.getModifiers());
        }
        //调用无参构造
        Object object = clazz.newInstance();
        Student stu = (Student)object;   //相当于调用无参公有构造

        //调用公有有参构造
        Constructor con1 = clazz.getConstructor(String.class); //指定一个String类型且公有的构造方法
        Student stu2 = (Student) con1.newInstance("岐山高中"); // 通过newInstance实例化对象
        System.out.println(stu2.school);

        //通过反射机制可以强制调用私有构造方法
        Constructor con2 = clazz.getDeclaredConstructor(String.class, int.class); //获取俩个参数的私有构造方法
        con2.setAccessible(true);  //解除私有封装，强制调用私有构造
        Student stu3 = (Student) con2.newInstance("牛犇", 22);
        stu3.showInfo();

        Method[] ms = clazz.getMethods();   //获取所有公有方法
        Method[] mss = clazz.getDeclaredMethods();  //获取所有方法包括私有
        for (Method m : ms) {
            System.out.println("方法名"+m.getName());
            System.out.println("返回值类型"+m.getReturnType());
            System.out.println("修饰符"+m.getModifiers());
            Class[] ps = m.getParameterTypes();    //获取参数类型
            if (ps != null && ps.length > 0) {
                for (Class p : ps) {
                    System.out.println("参数类型："+p.getName());
                }
            }
            System.out.println("*********************");
        }


        //获取公有属性
        Field[] fields = clazz.getFields();
        //获取全部属性包括私有
        for (Field field : fields) {
            System.out.println("属性名称："+field.getName());
            System.out.println("属性类型："+field.getType());
            System.out.println("属性修饰符："+field.getModifiers());
       }

        //调用指定方法
        Method m = clazz.getMethod("showInfo"); //无参不用写，有参后面写参数类型
       Constructor con = clazz.getConstructor();  //调用无参构造器构造对象
        Object ob = con.newInstance(); // 实例化
        m.invoke(ob);  //调用指定方法 参数1：需要实例化的对象 ，参数2：调用方法的参数
        //调用指定方法（可以调用私有方法）
        Method m1 = clazz.getDeclaredMethod("test", String.class);
        m1.setAccessible(true);  //强制调用私有方法 解除私有封装
        m1.invoke(ob, "New");

        clazz.getDeclaredMethod("showInfo", String.class);


    }
}


