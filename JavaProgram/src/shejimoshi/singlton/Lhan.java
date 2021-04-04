package shejimoshi.singlton;

//懒汉式   线程不安全
public class Lhan {
    private Lhan lhan;

    private Lhan() {
    }

    public Lhan getInstance() {
        if (lhan == null) {
            lhan = new Lhan();
        }
        return lhan;
    }
}
