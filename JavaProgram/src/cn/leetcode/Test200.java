package cn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Test200 {
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        int x = a.length, y = a[0].length,res = 0;
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y ; j++) {
                if (a[i][j] == 1) {
                    bfs(a, i, j);
                    res += 1;
                }
            }
        }
        System.out.println(res);
    }

    public static void bfs(int[][] a,int i,int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int[][] turn = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int nextI = next[0];
            int nextJ = next[1];
            for (int k = 0; k <4 ; k++) {
                int newI = nextI + turn[k][0];
                int newJ = nextJ + turn[k][1];
                if (newI < 0 || newI >= a.length || newJ < 0 || newJ >= a[0].length || a[newI][newJ] == 0) {
                    continue;
                }
                a[newI][newJ] = 0;
                queue.add(new int[]{newI, newJ});
            }
        }
    }
}

