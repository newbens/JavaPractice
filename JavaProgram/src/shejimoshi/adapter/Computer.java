package shejimoshi.adapter;


//�ͻ�����
public class Computer {
    //��������
    public void net(NetToUsb netToUsb) {
        //��һ������ת��ͷ
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
