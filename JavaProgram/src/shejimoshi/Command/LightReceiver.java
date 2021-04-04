package shejimoshi.Command;

/**
 * 具体命令执行者
 */
public class LightReceiver {
    public void on() {
        System.out.println("电灯打开了 ");
    }

    public void off() {
        System.out.println("电灯关闭了 ");
    }
}
