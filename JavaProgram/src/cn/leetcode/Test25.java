package cn.leetcode;

public class Test25 {
    /**
     * 链表分段反转
     */
    public static void main(String[] args) {
        LinkedNode head1 = new LinkedNode(1);
        LinkedNode head2 = new LinkedNode(2);
        LinkedNode head3 = new LinkedNode(3);
        LinkedNode head4 = new LinkedNode(4);
        LinkedNode head5 = new LinkedNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;


    }


    public  LinkedNode solve(LinkedNode head, int k) {
        LinkedNode d = new LinkedNode(0);
        d.next = head;
        LinkedNode start = d;
        LinkedNode end = d;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            LinkedNode begin = start.next;
            LinkedNode late = end.next;
            end.next = null;
            LinkedNode reserve = reserve(begin);
            start.next = reserve;
            begin.next = late;
            start = begin;
            late = start;
        return d.next;

//            LinkedNode s = start.next;
//            LinkedNode e = end.next;
//             end.next = null;
//            LinkedNode reserve = reserve(s);
//            start.next = reserve;
//            s.next = e;
//            start = s;
//            end = start;
//            return d.next;
        }

        return d.next;
    }

    public LinkedNode reserve(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode pre = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}

class LinkedNode {
    LinkedNode next;
    Integer id;

    public LinkedNode(Integer id) {
        this.id = id;
    }

}




