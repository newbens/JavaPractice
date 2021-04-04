import java.util.concurrent.TimeUnit;

/**
 * 参数测试
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("HELLO GC");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
