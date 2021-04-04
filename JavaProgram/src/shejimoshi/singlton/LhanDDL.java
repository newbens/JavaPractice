package shejimoshi.singlton;

//线程安全懒汉式
public class LhanDDL {
    private volatile LhanDDL lhanDDL;

    private LhanDDL() {
    }

    public LhanDDL getInstance() {
        if (lhanDDL == null) {
            synchronized (LhanDDL.class) {
                if (lhanDDL == null) {
                    lhanDDL = new LhanDDL();
                }
            }
        }
        return lhanDDL;
    }
}
