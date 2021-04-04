package thread.test;

public class TestRuannable  implements Runnable {
    @Override
    public void run() {
        int coount = 0;
//        System.out.println("RUNNABLE！！！"+Thread.currentThread().getName());
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+coount);
            coount += 1;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
