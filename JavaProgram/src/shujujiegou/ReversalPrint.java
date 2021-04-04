package shujujiegou;

import java.util.Stack;

public class ReversalPrint {               //反向打印单链表
    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1, "1", "a");
        Node n2 = new Node(2, "2", "b");
        Node n3 = new Node(3, "3", "c");
        s.addNode(n1);
        s.addNode(n2);
        s.addNode(n3);
//        s.showList();
        reversalPrint(s);

    }

    public static void reversalPrint(SingleLinkedList s) {
        Stack<Node> stack = new Stack<>();
        Node header = s.head;
        while (header != null) {
            stack.push(header);
            header = header.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
