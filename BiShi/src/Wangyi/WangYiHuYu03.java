package Wangyi;

import java.util.*;

/**
 * 1
 * 8
 * 1 1 0
 * 5 2 0
 * 10 3 0
 * 20 3 1
 * 25 4 0
 * 40 4 1
 * 1000 2 1
 * 2000 1 1
 */
public class WangYiHuYu03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int realTime = 0;
        int maxID = 0;
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int time = sc.nextInt();
                int id = sc.nextInt();
                int flag = sc.nextInt();
                if (flag == 0) stack.push(new Node(time, flag, id));
                else {
                    Node pop = stack.pop();
                    realTime = time - pop.time - pop.c;
                    if(!stack.isEmpty())  stack.peek().c += time - pop.time;
                }
                if (realTime > res) {
                    res = realTime;
                    maxID = id;
                }
            }
        }
        System.out.println("MAXTIME="+res+" ,ID="+ maxID);
    }


    public static class Node {
        int id;
        int flag;
        int time;
        int c;

        public Node(int time, int flag, int id) {
            this.id = id;
            this.flag = flag;
            this.time = time;
            this.c = 0;
        }
    }
}
