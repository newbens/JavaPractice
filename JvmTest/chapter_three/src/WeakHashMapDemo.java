import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        System.out.println("********************HashMap************************");
        myHashMap();
        System.out.println("*******************WeakHashMap*********************");
        myWeakHashMap();
    }

    public static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String s = new String("HashMap");

        map.put(key, s);
        System.out.println(map);

        key = null;

        System.gc();
        System.out.println(map);

    }
    public static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String s = new String("WeakHashMap");

        map.put(key, s);
        System.out.println(map);

        key = null;  //key设置为null  ，没有了引用指向，WeakHashMap便会被回收

        System.gc();
        System.out.println(map);

    }
}
