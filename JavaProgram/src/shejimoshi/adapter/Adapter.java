package shejimoshi.adapter;

//真正的适配器
public class Adapter extends Adptee implements NetToUsb {

    //将网线与电脑相连
    @Override
    public void handleRequest() {
        super.request();
    }
}
