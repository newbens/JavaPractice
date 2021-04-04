package shejimoshi.singlton;

//¶öººÊ½
public class Ehan {
    private Ehan ehan = new Ehan();

    private Ehan() {
    }

    public Ehan getInsstance() {
        return ehan;
    }
}
