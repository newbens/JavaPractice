package shejimoshi.singlton;

//����ʽ
public class Ehan {
    private Ehan ehan = new Ehan();

    private Ehan() {
    }

    public Ehan getInsstance() {
        return ehan;
    }
}
