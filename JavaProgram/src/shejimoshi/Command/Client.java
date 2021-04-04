package shejimoshi.Command;

public class Client {
    public static void main(String[] args) {
        //ң�����Ե�ƵĲ���
        LightReceiver light = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        //ң����
        RemoteController rc = new RemoteController();
        //ң������ʼ��
        rc.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("--------------------------------------");
        rc.onButton(0);
        rc.offButton(0);
        rc.undoButton();
        rc.undoButton();
    }
}
