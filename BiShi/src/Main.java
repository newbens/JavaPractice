import java.util.Scanner;
import java.io.File;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    public int x;
    public int y;
    public int layer;
    public Node(int x, int y, int layer) {
        this.x = x;
        this.y = y;
        this.layer = layer;
    }
}
public class Main {
    public static void main(String[] args) throws Exception{
        //File file = new File("in.txt");
        //Scanner in = new Scanner(file);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] board = new char[n][n];
        int startX = -1; int startY = -1;
        int endX = -1; int endY = -1;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        in.close();
        if(startX == -1 && startY == -1) System.out.println("-1");
        if(endX == -1 && endY == -1) System.out.println("-1");

        Queue<Node> queue = new LinkedList<Node>();
        int x = -1; int y = -1;
        queue.offer(new Node(startX, startY, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            //找到最后结果
            if (node.x == endX && node.y == endY) {
                System.out.println(node.layer);
                return;
            }

            //四个方向
            x = node.x + 1; y = node.y;
            if(x == n) x = 0;
            if(board[x][y] != '#') {queue.offer(new Node(x, y, node.layer + 1)); board[x][y] = '#';}

            x = node.x - 1; y = node.y;
            if(x == -1) x = n-1;
            if(board[x][y] != '#') {queue.offer(new Node(x, y, node.layer + 1)); board[x][y] = '#';}

            x = node.x; y = node.y + 1;
            if(y == n) y = 0;
            if(board[x][y] != '#') {queue.offer(new Node(x, y, node.layer + 1)); board[x][y] = '#';}

            x = node.x; y = node.y - 1;
            if(y == -1) y = n-1;
            if(board[x][y] != '#') {queue.offer(new Node(x, y, node.layer + 1)); board[x][y] = '#';}
        }
        System.out.println("-1");
    }
}




