package NiuKe;

public class Test1 {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(3);
        LinkNode node3 = new LinkNode(4);
        LinkNode node4 = new LinkNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkNode newHead = rever(head);
        System.out.println(newHead.next.val);
    }

    public static LinkNode rever(LinkNode head) {
        if(head == null || head.next == null) return head;
        LinkNode pre = rever(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public static class LinkNode{
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }
}
