package 达达;

import java.util.*;

public class Main2 {
    static LinkNode head1 ;
    static LinkNode head2 ;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        List<Integer> all = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("|")) {
                flag = i + 1;
                String[] split1 = split[i].split("|");
                all.add(Integer.valueOf(split1[0]));
                all.add(Integer.valueOf(split1[2]));
            } else {
                all.add(Integer.valueOf(split[i]));
            }
        }
        LinkNode link1 = new LinkNode(Integer.valueOf(all.get(0)));
        head1 = link1;
        LinkNode link2 = new LinkNode(Integer.valueOf(all.get(flag)));
        head2 = link2;
        for (int i = 1; i < flag; i++) {
            link1.next = new LinkNode(Integer.valueOf(all.get(i)));
            link1 = link1.next;
        }
        for (int i = flag+1; i < all.size(); i++) {
            link2.next = new LinkNode(Integer.valueOf(all.get(i)));
            link2 = link2.next;
        }
        LinkNode merge = merge(head1, head2);
        while (merge != null) {
            if (merge.next == null) {
                System.out.print(merge.val);
            }else {
                System.out.print(merge.val+",");
            }
            merge = merge.next;
        }
    }

    public static LinkNode merge(LinkNode h1,LinkNode h2) {
        LinkNode head = new LinkNode(0);
        LinkNode temp = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                head.next = h1;
                h1 = h1.next;
                head = head.next;
            }else {
                head.next = h2;
                h2 = h2.next;
                head = head.next;
            }
        }
        while (h1 != null) {
            head.next = h1;
            h1 = h1.next;
            head = head.next;
        }
        while (h2 != null) {
            head.next = h2;
            h2 = h2.next;
            head = head.next;
        }
        return temp.next;
    }
    static class LinkNode{
        LinkNode next;
        int val;

        public LinkNode(int val) {
            this.val = val;
        }
    }

}
