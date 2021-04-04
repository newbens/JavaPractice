package cn.leetcode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = new Test().updateMatrix(a);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] updateMatrix(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int[][] turn = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if (a[i][j] == 0) {   //将值为0的节点，存入队列。
                    queue.add(new int[]{i,j});
                }else{              //将不是0的赋值为一个较大的值。
                    a[i][j] = 1000;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] z = queue.poll();
            int x = z[0];
            int y = z[1];
            for (int i = 0; i <4 ; i++) {
                int newx = x + turn[i][0];
                int newy = y + turn[i][1];
                if (newx >= 0 && newx < row && newy >= 0 && newy < col) {
                    if (a[newx][newy] > a[x][y] + 1) {
                        a[newx][newy] = a[x][y] + 1;
                        queue.add(new int[]{newx, newy});
                    }
                }
            }
        }
        return a;
    }

    @org.junit.Test
    public void test() {
        Integer a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            a = a ++;
        }
        System.out.println(a);

    }

}


