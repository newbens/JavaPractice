package shejimoshi.Command;

import java.util.Stack;

/**
 * ң������
 */
public class RemoteController {

    Command[] onCommand;  //�������
    Command[] offCommand; //�������
    Stack<Command> undo = new Stack<>(); //����ջ

    public RemoteController() { //��ʼ��ң����
        onCommand = new Command[5];
        offCommand = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommand[i] = new NoCommand();
            offCommand[i] = new NoCommand();
        }
    }

    public void setCommand(int index,Command on,Command off) {  //���ð�ť��������
        onCommand[index] = on;
        offCommand[index] = off;
    }

    public void onButton(int index) { //����ť
        onCommand[index].execute(); //ִ�п�����
        undo.push(onCommand[index]); // �볷��ջ
    }

    public void offButton(int index) {
        offCommand[index].execute();
        undo.push(offCommand[index]);
    }

    public void undoButton() { //��������
        if (undo.isEmpty()) {
            System.out.println("�޷�������");
        }
        undo.pop().undo();
    }
}
