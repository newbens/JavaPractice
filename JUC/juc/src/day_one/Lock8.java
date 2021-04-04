package day_one;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/**
 * 八锁:
 *     1.标准访问，先打印邮件还是短信
 *     2。暂停4秒邮件方法
 *          普通方法锁的是对象，静态方法锁的是整个类
 *          一个对象里面如果有多个synchronized方法，同一时间只能有一个线程去调用其中的一个synchronized方法。
 *     3。新增sayHello方法
 *          先执行sayHello因为sayHello方法不用争锁
 *     4.两部手机
 *          多个锁，先打印Sms
 *     5.两个静态同步方法，同一部手机，先打印什么
 *     6.两个静态方法，两部手机
 *          static synchronized 锁的是类资源
 *     7.一个静态方法，一个普通方法，一部手机
 *     8.一个静态方法，一个普通方法，两部手机
 *          都是先打印sayHello
 */

class Phone{

    public synchronized void sendMail() throws Exception {
        TimeUnit.SECONDS.sleep(4);//停4秒
        System.out.println("发邮件");
    }
    public synchronized void sendSms() throws Exception {
        System.out.println("发SMS");
    }

    public void sayHello() throws Exception {
        System.out.println("Hello");
    }

}

public class Lock8 {
    HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "a").start();

        Thread.sleep(400);

        new Thread(() -> {
            try {
//                phone.sendSms();
                phone2.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "a").start();
    }

}

