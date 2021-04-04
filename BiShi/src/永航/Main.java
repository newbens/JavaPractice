package 永航;

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(deleteDuplicates(n1));

    }

    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null )return head;
        ListNode res = head;
        ListNode pre = head;
        head = head.next;
        while(head != null ){
            if(head.val == pre.val){
                pre.next = head.next;
            }else{
                pre = head;
            }
            head = head.next;
        }
        return res;
    }

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
