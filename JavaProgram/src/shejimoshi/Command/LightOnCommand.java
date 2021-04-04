package shejimoshi.Command;

/**
 * 具体开灯命令类
 */
public class LightOnCommand implements Command {

    LightReceiver light;  //命令实行者

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() { //执行
        light.on();
    }

    @Override
    public void undo() { //撤销
        light.off();
    }
}
