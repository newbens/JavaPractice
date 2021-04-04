/**
 * --------------------栈管运行---堆管存储------------------------
 *
 *
 */

public class JvmNote {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory();//返回jvm试图使用的最大内存量  默认1/4    -Xmx
        long totalMemory = Runtime.getRuntime().totalMemory();//返回jvm虚拟机内存总量  默认 1/64  -Xms
        System.out.println(maxMemory/1024/1024);
        System.out.println(totalMemory/1024/1024);

    }
}
