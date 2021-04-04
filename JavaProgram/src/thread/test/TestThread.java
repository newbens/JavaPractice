package thread.test;

public class TestThread extends Thread {
    @Override
    public void run() {   //重写Run方法  将需要多线程实现的代码写在run里面
        System.out.println("对线程运行代码");
//        for (int i = 0; i <10 ; i++) {
//            System.out.println("对线程"+i);
//        }
    }
}
