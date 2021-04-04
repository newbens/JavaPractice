package shujujiegou;
//   约瑟夫环
public class Josephu {
    public static void main(String[] args) {
        CircleLinkedList c = new CircleLinkedList();
        c.addBoy(25);
        c.countBoy(1,2,25);
    }
}
//创建环形链表
class CircleLinkedList{
    //创建first节点
    private Boy first = new Boy(-1);

    public void addBoy(int n) {
        if (n < 1) {
            System.out.println("输入不正确！");
            return;
        }
        Boy curBoy = null; //辅助指针
        for (int i = 1; i <= n ; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;          //先给头节点赋值，
                first.setNext(first);   //构成一个环
                curBoy = first;        //把头节点赋值给辅助指针
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("链表为空！！！");
            return;
        }
        Boy help = first;                //辅助指针
        while (true) {
            System.out.printf("编号：%d \n",help.getId());
            if (help.getNext() == first) {
                break;
            }
            help = help.getNext();
        }
    }
    /*出圈次序
    @param startNum 从第几个节点开始计数
    @param countNum  数的数字大小
    @param nums       节点总数
    */
    public void countBoy(int startNum,int countNum,int nums) {
        //先对数据验证
        if (first == null || startNum > nums || startNum < 1) {
            System.out.println("参数输入有误！！！");
            return;
        }
        Boy help = first;  // 辅助指针
        while (true) {         //让help辅助指针移动到最后一个节点
            if (help.getNext() == first) {
                break;
            }
            help = help.getNext();
        }
        while (startNum > 1) {   //两个指针移动到指定的开始位置
            first = first.getNext();
            help = help.getNext();
            startNum --;
        }
        //开始移动出圈
        while (true) {
            if (help == first) {   //当help == frist时说明圈中只剩一个节点，结束
                break;
            }
            for (int i =1;i < countNum ;i++) {   //计算出圈的节点
                first = first.getNext();
                help = help.getNext();
            }
            System.out.printf("节点：%d出圈 \n",first.getId());
            first = first.getNext();    //frist前移一位
            help.setNext(first);       //help的next指向Frist，完成出圈
        }
        System.out.printf("最后一个留在圈中的节点是：%d\n",help.getId());
    }

}

class Boy{
    private Boy next;
    private int id;

    public Boy(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}