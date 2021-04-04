package GoWhere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuZaLianBiao {
    public static void main(String[] args){
        LinkNode node1 = new LinkNode(7);
        LinkNode node2 = new LinkNode(13);
        LinkNode node3 = new LinkNode(11);
        LinkNode node4 = new LinkNode(10);
        LinkNode node5 = new LinkNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        LinkNode copyHead = copy(node1);
        System.out.println(copyHead.next.val);
        System.out.println(copyHead.next.random.val);
    }

    public static LinkNode copy(LinkNode head) {
        List<LinkNode> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        LinkNode temp = head;
        while (temp != null ) {
            list.add(temp);
            temp = temp.next;
        }
        int i = 0;
        LinkNode temp2 = head;
        while (temp2 != null) {
            int index = list.indexOf(temp2.random);
            map.put(i++, index);
            temp2 = temp2.next;
        }
        for (int j = 0; j < list.size() - 1; j++) {
            list.get(j).next = list.get(j + 1);
            if(map.get(j) == -1) continue;
            else {
                list.get(j).random = list.get(map.get(j));
            }
        }
        return list.get(0);
    }
    public static class LinkNode{
        int val;
        LinkNode next;
        LinkNode random;

        public LinkNode(int val) {
            this.val = val;
        }
    }
}
