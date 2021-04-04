package shejimoshi.Command;

/**
 * æﬂÃÂπÿµ∆√¸¡Ó
 */
public class LightOffCommand implements Command {

    LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
