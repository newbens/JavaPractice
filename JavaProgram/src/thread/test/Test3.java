package thread.test;

public class Test3 {
    public static void main(String[] args) {
    //消费时不生产，生产时不消费
        Clerk c = new Clerk();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c) {
                    while (true) {   //无限生产
                        if (c.productNum == 0) {
                            System.out.println("产品数为0，开始生产！");
                            while (c.productNum < 4) {
                                c.productNum += 1;
                                System.out.println("库存 ：" + c.productNum);
                                c.notify();  //唤醒消费者
                            }
                            System.out.println("产品数为" + c.productNum + ",结束生产");
                        } else {
                            try {
                                c.wait();  //挂起生产者
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "生产者").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c) {
                    while (true) {   //无限生产
                        if (c.productNum == 4) {
                            System.out.println("产品数为4，开始消费！");
                            while (c.productNum > 0) {
                                c.productNum -= 1;
                                System.out.println("库存 ：" + c.productNum);
                            }
                            System.out.println("产品数为" + c.productNum + ",结束消费");
                            c.notify(); //唤醒生产者
                        } else {
                            try {
                                c.wait();//挂起消费者
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "消费者").start();
    }
}
class Clerk{
    static int productNum = 0;
}
