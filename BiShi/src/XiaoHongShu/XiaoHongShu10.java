package XiaoHongShu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class XiaoHongShu10 {
    static int step = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        char[][] map = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        int beginX = -1;
        int beginY = -1;
        int endX = - 1;
        int endY = -1;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    beginX = i;
                    beginY = j;
                }
                if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        in.close();
        if(beginX == -1 && beginY == -1) System.out.println("-1");
        if(endX == -1 && endY == -1) System.out.println("-1");
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> help = new LinkedList<>();
        queue.offer(new int[]{beginX,beginY});
        int step = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x =  poll[0];
            int y =  poll[1];
            if (x == endX && y == endY) {
                System.out.println(step);
                return;
            }
            //四个方向
            if(map[(x+1)%n][y] != '#') {
                help.offer(new int[]{(x+1)%n,y});
                map[(x+1)%n][y] ='#';
            };

            x = x - 1;
            if(x < 0 ) x = n - 1;
            if(map[x][y] != '#'){
                help.offer(new int[]{x,y});
                map[x][y] ='#';
            }

            if(map[x][(y+1)%n] != '#') {
                help.offer(new int[]{x,(y+1)%n});
                map[x][(y+1)%n] ='#';
            }

            y = y - 1;
            if(y < 0 ) y = n - 1;
            if(map[x][y] != '#') {
                help.offer(new int[]{x,y});
                map[x][y] ='#';
            }

            if (queue.isEmpty()) {
                step++;
                for (int i = 0; i < help.size(); i++) {
                    queue.offer(help.poll());
                }
            }
        }
        System.out.println("-1");
//        dfs(beginX, beginY, map, visited, 0);
//        if(step == Integer.MAX_VALUE) System.out.println("-1");
//        else System.out.println(step);
    }

    public static void dfs(int x, int y, char[][] map, boolean[][] visited, int stepSum) {
        if (x < 0) x = n - 1;
        if (y < 0) y = n - 1;
        if (map[x][y] == '#' || visited[x][y]) return;
        if (map[x][y] == 'E') step = Math.min(step, stepSum);
        visited[x][y] = true;
        stepSum++;
        dfs((x + 1) % n, y % n, map, visited, stepSum);
        dfs(x % n, (y + 1) % n, map, visited, stepSum);
        dfs(x % n, (y - 1) % n, map, visited, stepSum);
        dfs((x - 1) % n, y % n, map, visited, stepSum);
        stepSum--;
        visited[x][y] = false;
    }
}
