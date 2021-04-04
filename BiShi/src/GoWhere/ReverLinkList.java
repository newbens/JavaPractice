package GoWhere;

public class ReverLinkList {
    public static void main(String[] args){
        FuZaLianBiao.LinkNode node1 = new FuZaLianBiao.LinkNode(1);
        FuZaLianBiao.LinkNode node2 = new FuZaLianBiao.LinkNode(2);
        FuZaLianBiao.LinkNode node3 = new FuZaLianBiao.LinkNode(3);
        FuZaLianBiao.LinkNode node4 = new FuZaLianBiao.LinkNode(4);
        FuZaLianBiao.LinkNode node5 = new FuZaLianBiao.LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        FuZaLianBiao.LinkNode rever = rever(node1);
        System.out.println(rever.val);
    }
    public static FuZaLianBiao.LinkNode rever(FuZaLianBiao.LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        FuZaLianBiao.LinkNode pre = rever(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
