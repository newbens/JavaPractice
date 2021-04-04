package shujujiegou;

import java.util.Scanner;

public class ArrayQueue {
    private int maxSize;
    private int front;   //队列头
    private int tail;    //队列尾
    private int[] arr;

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("S : 显示队列");
            System.out.println("A : 添加数据");
            System.out.println("G : 取出数据");
            System.out.println("P : 查看队头");
            System.out.println("E : 退出");
            System.out.println("请做出选择:");
            char in = input.next().charAt(0);  //接受字符
            switch (in) {
                case 'S':
                    arrayQueue.show();
                    break;
                case 'A':
                    System.out.println("请输入想要添加的数据：");
                    int x = new Scanner(System.in).nextInt();
                    arrayQueue.add(x);
                    break;
                case 'G':
                    try {
                        int data = arrayQueue.get();
                        System.out.printf("取出的数据为：%d",data);
                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'P':
                    try {
                        int peek = arrayQueue.peek();
                        System.out.println(peek);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'E':
                    input.close();  //退出时关闭
                    loop = false;
                    break;
            }
        }
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        tail = 0;


    }
    public boolean isFull() {
        return (tail+1)%maxSize == front;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满！！");
            return;
        }
        arr[tail] = n;
        tail = (tail + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw  new RuntimeException("队列空！！！！");
        }
        int data = arr[front];
        front = (front+1)%maxSize;
        return data;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空！！！！");
            return;
        }

        for (int i = front; i <front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size() {
        return (tail + maxSize - front)%maxSize;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("队列为空！！！！");
            return 0;
        }
        return arr[front];
    }

}

