package shejimoshi.Command;

public class Client {
    public static void main(String[] args) {
        //Ò£¿ØÆ÷¶ÔµçµÆµÄ²Ù×÷
        LightReceiver light = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        //Ò£¿ØÆ÷
        RemoteController rc = new RemoteController();
        //Ò£¿ØÆ÷³õÊ¼»¯
        rc.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("--------------------------------------");
        rc.onButton(0);
        rc.offButton(0);
        rc.undoButton();
        rc.undoButton();
    }
}
