package shujujiegou;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1, "宋江");
        DoubleNode node2 = new DoubleNode(2, "卢俊义");
        DoubleNode node3 = new DoubleNode(3, "吴用");
        DoubleNode node4 = new DoubleNode(4, "林冲");
        DoubleList d = new DoubleList();
        d.addNode(node1);
        d.addNode(node2);
        d.addNode(node3);
        d.showList();


    }




}
//双向链表类

class DoubleList{

    public  DoubleNode head = new DoubleNode(0, "0");

    public void showList() {             //打印单链表
        if (head.next == null) {
            System.out.println("链表为空！！！！");
            return;
        }
        DoubleNode temp = head.next;
        while (true) {
            if (temp == null) {         //判断是否为空
                return;
            }
            System.out.println(temp);
            temp = temp.next;          //后移
        }

    }

    public void addNode(DoubleNode node) {        //添加结点
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void reSet(DoubleNode node, int n) {     //修改结点
        DoubleNode temp = head;
        while (n >0) {
            temp = temp.next;
            n--;
        }
        node.next = temp.next.next;
        temp.next = node;
        node.pre = temp;
    }

    public Double find(int n) {                  //查
        DoubleNode temp = head;
        while (n >= 0) {
            temp = temp.next;
            n--;
        }
        System.out.println(temp);

        return null;
    }

    public void delete(int n) {                //删除操作
        DoubleNode temp = head;
        while (n >= 0) {
            temp = temp.next;
            n--;
        }
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;

    }

    public void insert(DoubleNode node, int n) {    //n表示插入位置
        DoubleNode temp = head;
        while (n >= 0) {
            temp = temp.next;
            n--;
        }
        node.pre = temp.pre;
        temp.pre = null;
        node.next = temp.next;
        temp.next = null;

    }


}
class DoubleNode {
    public int no;
    public DoubleNode next;
    public String name;
    public DoubleNode pre;

    public DoubleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}