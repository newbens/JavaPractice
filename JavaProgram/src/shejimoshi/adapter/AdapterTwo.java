package shejimoshi.adapter;

public class AdapterTwo implements NetToUsb {  //¡Ì“ª∏ˆ  ≈‰

    private Adptee adptee;

    public AdapterTwo(Adptee adptee) {
        this.adptee = adptee;
    }

    @Override
    public void handleRequest() {
        adptee.request();
    }
}
