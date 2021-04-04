import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();

        ReferenceQueue referenceQueue = new ReferenceQueue();//引用队列
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        //**********GC前***************
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll()); //GC前为null
        //**********GC后***************
        o1 = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());//GC后，会进入引用队列

    }
}
