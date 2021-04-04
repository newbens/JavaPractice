package shejimoshi.adapter;


//客户端类
public class Computer {
    //上网方法
    public void net(NetToUsb netToUsb) {
        //找一个网线转接头
        netToUsb.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adptee adptee = new Adptee();
        Adapter adapter = new Adapter();
        AdapterTwo adapterTwo = new AdapterTwo(adptee);

        computer.net(adapter);
        computer.net(adapterTwo);
    }
}
