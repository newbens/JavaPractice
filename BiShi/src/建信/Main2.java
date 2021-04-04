package 建信;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        int[][] m = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int friendNum = new Main2().findFriendNum(m);
        System.out.println(friendNum);
    }
    public int findFriendNum (int[][] M) {
        boolean[] visit = new boolean[M.length];
        int res = 0;
        while (check(visit) != -1) {
            findFriend(M, visit, check(visit));
            res++;
        }
        return res;
    }

    public int check(boolean[] visit){
        for (int i = 0; i < visit.length; i++) {
            if(visit[i] == false) return i;
        }
        return -1;
    }

    public void findFriend(int[][] m,boolean[] visit,int index) {
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(index);
        while (!q.isEmpty()) {
            int n = q.removeFirst();
            for (int i = 0; i < m[n].length; i++) {
                if(m[n][i] == 1){
                    if(!set.contains(i)){
                        set.add(i);
                        q.addLast(i);
                        visit[i] = true;
                    }
                }
            }
        }
    }
}
