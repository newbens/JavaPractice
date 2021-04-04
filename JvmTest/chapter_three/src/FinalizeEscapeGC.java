import java.util.concurrent.TimeUnit;

/**
 *  ---------------一次对象的自我拯救---------------------------
 */

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("我还活着！");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法被执行了");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        //Finalizer 方法优先级低，暂停1秒，等待
        TimeUnit.SECONDS.sleep(1);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("我死了");
        }

        //finalize只会被执行一次，下次对象还是会被杀死。
    }
}
