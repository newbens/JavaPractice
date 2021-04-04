package cn.leetcode;

//�ϲ�k����������
public class Test23 {
    public static void main(String[] args) {
        SingleList s1 = new SingleList();
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(5);
        s1.tailAdd(a);
        s1.tailAdd(b);
        s1.tailAdd(c);
        SingleList s2 = new SingleList();
        Node d = new Node(1);
        Node e = new Node(3);
        Node f = new Node(4);
        s2.tailAdd(d);
        s2.tailAdd(e);
        s2.tailAdd(f);
        SingleList s3 = new SingleList();
        Node g = new Node(2);
        Node h = new Node(6);
        s3.tailAdd(g);
        s3.tailAdd(h);
        Node[] list = {a, d, g};
        Node res = slove2(list);
        System.out.println(res.next.next.next.id);

    }

    /********************************�ⷨһ**************************
     * ���ù鲢�����˼�����ʵ��:
     *     1.�ݹ齫�����е������������
     *     2.�ݹ�ʵ������
     *
     */
    public static Node mergeKLists(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int len = lists.length;
        return solve(lists,0,len-1);
    }

    public static Node solve(Node[] list,int start,int end) {
        if (start == end) {
            return list[start];
        }
        int mid = start + (end - start) / 2;
        Node left = solve(list, start, mid);
        Node right = solve(list, mid + 1, end);
        return sort(left, right);
    }

    public static Node sort(Node left,Node right) {
        if (left == null) return right;
        if(right == null) return left;
        if (left.id < right.id) {
            left.next = sort(left.next, right);
            return left;
        }else{
            right.next = sort(left, right.next);
            return right;
        }
    }

    /***********************************�ⷨ��******************************
     * ˼·:
     *      ��һ��������������֣������ϲ���ֱ�����鳤��Ϊһʱ��������return
     *      �ڶ���  ʵ��������ϲ���
     */
    public static Node slove2(Node[] list) {
        int len = list.length;
        if(len == 0) return  null;
        while (len > 1) {
            for (int j = 0; j <len/2  ; j++) {
                list[j] = sort2(list[j], list[len - 1 - j]);
            }
            len = (len + 1) / 2;
        }
        return list[0];
    }

    public static Node sort2(Node left,Node right) {
        Node head = new Node(0);
        Node temp = head;
        while (left.next != null && right.next != null) {
            if (left.id < right.id) {
                temp.next = left;
                left = left.next;
            }else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left !=  null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return head.next;
    }
}

