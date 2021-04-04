package shejimoshi.Command;

import java.util.Stack;

/**
 * 遥控器类
 */
public class RemoteController {

    Command[] onCommand;  //开命令集合
    Command[] offCommand; //关命令集合
    Stack<Command> undo = new Stack<>(); //撤销栈

    public RemoteController() { //初始化遥控器
        onCommand = new Command[5];
        offCommand = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommand[i] = new NoCommand();
            offCommand[i] = new NoCommand();
        }
    }

    public void setCommand(int index,Command on,Command off) {  //设置按钮具体命令
        onCommand[index] = on;
        offCommand[index] = off;
    }

    public void onButton(int index) { //开按钮
        onCommand[index].execute(); //执行开操作
        undo.push(onCommand[index]); // 入撤销栈
    }

    public void offButton(int index) {
        offCommand[index].execute();
        undo.push(offCommand[index]);
    }

    public void undoButton() { //撤销功能
        if (undo.isEmpty()) {
            System.out.println("无法撤销！");
        }
        undo.pop().undo();
    }
}
