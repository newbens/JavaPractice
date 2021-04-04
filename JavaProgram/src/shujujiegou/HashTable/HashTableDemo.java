package shujujiegou.HashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable ht = new HashTable(2);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("add:  添加");
            System.out.println("list:  全部显示");
            System.out.println("find:  查找");
            System.out.println("del:  删除");
            System.out.println("exit:  退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名：");
                    String name = scanner.next();
                    Node node = new Node(id, name);
                    ht.add(node);
                    break;
                case "list":
                    System.out.println("全部信息为：");
                    ht.list();
                    break;
                case "find":
                    System.out.println("输入查找姓名：");
                    String names = scanner.next();
                    Node info = ht.find(names);
                    System.out.println("ID:"+info.id+",姓名："+info.name);
                    System.out.println("********************");
                    break;
                case "del":
                    System.out.println("输入想删除的姓名：");
                    String delName = scanner.next();
                    ht.delete(delName);
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
    }
}

class Node{
    public String name;
    public int id;
    public Node next;
    public Node(int id,String name) {
        this.name = name;
        this.id = id;
    }
}
//创建链表

class LinkedList{
    public Node head;  //创建头节点

    public void add(Node node) {
        if (head == null) {
            head = node;
        }else{
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第"+i+"链表为空！");
        }
        Node temp = head;
        while (temp != null) {
            System.out.printf("第%d条链表信息为：ID：%d,NAME:%s",i,temp.id,temp.name);
            temp = temp.next;
        }
    }
}

class HashTable{
    private LinkedList[] ls;   //创建一个链表数组
    int size;
    public HashTable(int size) {
        this.size = size;
        ls = new LinkedList[size];  //切记初始化每一条链表!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i <size ; i++) {
            ls[i] = new LinkedList();
        }
    }


    public void add(Node node) {
        int index = (node.name.hashCode() & size-1);    //根据哈希值与最大下标与运算求插入下标；
        ls[index].add(node);
    }

    public void list() {                        //打印表中全部信息
        for (int i = 0; i < size ; i++) {
            ls[i].list(i+1);
            System.out.println();
        }
    }

    public Node find(String name) {            //查找单个信息
        int index = (name.hashCode() & size - 1);
        if (ls[index].head == null) {
            System.out.println("无本人信息！");
            return null;
        }
        Node temp = ls[index].head;         //将头节点赋值个辅助变量
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("********************");
                return temp;
            }else{
                temp = temp.next;
            }temp = null;
        }
        return temp;
    }

    public void delete(String name) {    //删除大致和查找一样
        int index = (name.hashCode() & size - 1);
        if (ls[index].head == null) {
            System.out.println("无本人信息！");
            return;
        }
        Node temp = ls[index].head;
        if (temp.name.equals(name)) {
            ls[index].head = temp.next;
            System.out.println("删除成功！");
            return;
        }
        while (temp != null) {
            if (temp.next.name.equals(name)) {
                temp.next = temp.next.next;
                System.out.println("删除成功！");
                break;
            }else{
                temp = temp.next;
            }
        }
    }
}