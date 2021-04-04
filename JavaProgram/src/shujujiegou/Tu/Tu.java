package shujujiegou.Tu;

import java.util.ArrayList;
import java.util.Arrays;

public class Tu {
    private ArrayList<String> list; //存放顶点
    private int[][] edges; //邻接表
    private int bian;   //边的个数

    public static void main(String[] args) {
        Tu t = new Tu(5);
        String[] s = {"A", "B", "C", "D", "E"};
        //添加顶点
        for (String str : s) {
            t.addEdges(str);
        }
        //添加边
        t.addBian(0,1,1);
        t.addBian(0,2,1);
        t.addBian(2,1,1);
        t.addBian(3,1,1);
        t.addBian(4,1,1);
        t.showGraph();
    }

    public Tu(int bian) {
        this.bian = bian;
        edges = new int[bian][bian];
        list = new ArrayList<>(bian);
    }

    //插入结点
    public void addEdges(String insert) {
        list.add(insert);
    }

    /**
     * @param x,y 在邻接表中的下标
     * @param w 权值
     *
     */
    public void addBian(int x,int y,int w) {
        edges[x][y] = w;
        edges[y][x] = w;
        bian ++;
    }
    //得到顶点数
    public int getNum() {
        return list.size();
    }
    //得到边数
    public int getBian() {
        return bian;
    }
    //打印邻接矩阵
    public void showGraph() {
        for (int[] s : edges) {
            System.out.println(Arrays.toString(s));
        }
    }


}

