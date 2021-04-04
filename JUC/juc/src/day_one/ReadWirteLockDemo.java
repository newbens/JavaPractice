package day_one;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 */
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 写入数据"+key);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        readWriteLock.readLock().lock();
        Object object = null;
        try {
            System.out.println(Thread.currentThread().getName()+"\t 读取数据");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取成功"+object);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        return object;
    }
}
public class ReadWirteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCache.put(temp+"",temp);
                },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                Object object = myCache.get(temp + "");
                System.out.println(object+"**********************");
            },String.valueOf(i)).start();
        }
    }
}
