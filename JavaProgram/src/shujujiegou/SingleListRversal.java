package shujujiegou;

public class    SingleListRversal {
    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1, "A", "a");
        Node n2 = new Node(2, "B", "b");
        Node n3 = new Node(3, "C", "c");
        s.addNode(n1);
        s.addNode(n2);
        s.addNode(n3);
        Node n = new SingleListRversal().rev(s.head);
        System.out.println(n.next);
    }

    public  Node reversal(Node head) {
        if(head==null||head.next ==null)
            return head;
        Node prev = reversal(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public Node rev(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = rev(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}


