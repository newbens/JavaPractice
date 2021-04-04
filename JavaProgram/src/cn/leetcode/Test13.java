package cn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Test13 {
    public static void main(String[] args) {
        int m = 2, n = 3, k = 1;
//        int res = getStep(m, n, k);
//        int res2 = getStep2(m, n, k);
//        System.out.println(res);
//        int x = new Test13().add(12, 14);
//        System.out.println(x);
      int y =  getStep2(2, 3, 1);
        System.out.println(y);
    }

    public static int getStep(int m, int n, int k) {               //bfs解法
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});

        }
        return res;
    }

    public static int getStep2(int m, int n, int k) {    //解法二
        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, m, n, visited, k);
    }

    private static int dfs(int x, int y, int m, int n, boolean[][] visited, int k) {
        if (add(x, y) > k || x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, visited, k) + dfs(x, y + 1, m, n, visited, k);
    }

    private static int add(int x, int y) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x = x / 10;
        }
        while (y > 0) {
            res += y % 10;
            y = y / 10;

        }
        return res;
    }

}
