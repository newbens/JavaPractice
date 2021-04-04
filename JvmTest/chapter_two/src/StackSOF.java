

//可以通过 -Xss128k 调整栈大小
public class StackSOF {
    public static void main(String[] args) {
        new StackSOF().stackSOF();
    }

    public void stackSOF() {
        stackSOF();
    }
}
