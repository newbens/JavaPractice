package 携程;

import org.junit.Test;

import java.util.*;

public class Main2 {
    static class Node{
        int money;
        int group;

        public Node(int money, int group) {
            this.money = money;
            this.group = group;
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        list.add(new Node(10,1));
        list.add(new Node(30,1));
        list.add(new Node(100,2));
        list.add(new Node(200,2));
        list.add(new Node(150,3));
        list.add(new Node(50,3));
        list.add(new Node(60,4));
        list.add(new Node(20,4));


//        int i = 1;
//        while (cin.hasNextInt()) {
//            int incomeOfA = cin.nextInt();
//            int incomeOfB = cin.nextInt();
//            if(cin.next() == "#")break;
//            list.add(new Node(incomeOfA,i++));
//            list.add(new Node(incomeOfB,i++));
//        }
        System.out.println(getMax(list));
    }

    public static int getMax(List<Node> list) {
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.money - o2.money;
            }
        });
        Set<Integer> check = new HashSet<>();//后半段组号
        int left = list.size() - 1;
        int mid = list.size() / 2-1;
        for (int i = left; i >mid ; i--) {
            Node temp = list.get(i);
            check.add(temp.group);
        }
        int tep = mid;
        Set<Integer> set = new HashSet<>();
        for (int i = left; i >mid ; i--) {
            Node temp = list.get(i);
            if(!set.contains(temp.group)) set.add(temp.group);
            else {
                while (set.contains(list.get(tep).group)) {
                    tep--;
                }
                Node t = list.get(tep);
                temp.money = t.money;
                temp.group = t.group;
                tep--;
            }
        }
        int res = 0;
        for (int i = mid+1; i <= left; i++) {
            res += list.get(i).money;
        }
        return res;
    }
    
}
