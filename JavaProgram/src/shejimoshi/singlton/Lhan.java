package shejimoshi.singlton;

//����ʽ   �̲߳���ȫ
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
