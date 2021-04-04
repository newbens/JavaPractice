package shujujiegou;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList s = new SingleLinkedList();
        s.addNode(node1);
        s.addNode(node2);
        s.addNode(node3);       //添加
        s.delete(2);         //删除
        s.reSet(node4, 1);    //替换操作
        s.find(2);           //查找
        s.showList();

    }
}

//定义单链表
class SingleLinkedList {
    //初始化头节点，先不存放数据
    public  Node head = new Node(0, "", "");

    public void addNode(Node node) {        //添加结点
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void showList() {             //打印单链表
        if (head.next == null) {
            System.out.println("链表为空！！！！");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {         //判断是否为空
                return;
            }
            System.out.println(temp);
            temp = temp.next;          //后移
        }

    }

    public void insert(Node node, int n) {    //n表示插入位置
        Node temp = head;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void delete(int n) {                //删除操作
        Node temp = head;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        temp.next = temp.next.next;

    }

    public void find(int n) {                  //查
        Node temp = head;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        System.out.println(temp);

    }

    public void reSet(Node node, int n) {     //修改结点
        Node temp = head;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        node.next = temp.next.next;
        temp.next = node;
    }
}

//定义头节点
class Node {
    public int no;
    public Node next;
    public String name;
    public String nickname;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
