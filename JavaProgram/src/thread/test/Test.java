package thread.test;

public class Test {
    public static void main(String[] args) throws Exception{
//        Thread t = new TestThread();
//        t.start();  //启动多线程
//        Thread t = new Thread(new TestRuannable(),"线程一") ;
//        参数一 Runnable实例，参数二线程名
//        t.start();
//        System.out.println("!!!!!!!!!!!!");
//        Runnable r = new TestRuannable();
//        Thread t1 = new Thread(r, "线程一");
//        t1.start();
//        Thread t2 = new Thread(r, "线程二");
//        t2.start();
        TestRuannable r1 = new TestRuannable();
        TestRuannable r2 = new TestRuannable();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.setName("线程T1-");
        t2.setName("线程T2-");
        t1.setPriority(10);                     //设置优先级
        t2.setPriority(1);
//        t1.getPriority();                       //获取优先级
//        t2.getPriority();
//        System.out.println(t1.getName());       //获取名称
//        System.out.println(t2.getName());
        System.out.println("############");
        System.out.println("++++++++++++");
        t1.join();                           //插入当前位置，阻塞当前main方法先执行join进来的现成代码，执行完毕后释放阻塞
        System.out.println("************");
        System.out.println("------------");

    }
}
