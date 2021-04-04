package shejimoshi.Command;

/**
 * ���忪��������
 */
public class LightOnCommand implements Command {

    LightReceiver light;  //����ʵ����

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() { //ִ��
        light.on();
    }

    @Override
    public void undo() { //����
        light.off();
    }
}
