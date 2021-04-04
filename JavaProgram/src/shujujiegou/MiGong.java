package shujujiegou;

import java.util.Arrays;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //1表示不能走
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;
        for (int i = 0; i <map.length ; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        boolean x = getWay2(map, 1, 1);
        System.out.println("*************");
        for (int i = 0; i <map.length ; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
//        System.out.println(x);


    }

    //使用递归返回路径
    //@param  i,j表示初始位置
    //目标位置为地图右下角
    // 1:表示不能走，2：表示可走，3：为死路
    public static boolean getWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2; //假定可以走通；
                if (getWay(map, i + 1, j)) {
                    return true;
                } else if (getWay(map, i, j + 1)) {
                    return true;
                } else if (getWay(map, i - 1, j)) {
                    return true;
                } else if (getWay(map, i, j - 1)) {
                    return true;
                } else {               //如果到这一步说明这条路走不通，重新赋值为3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean getWay2(int[][] map, int i, int j) {
        int[][] next = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            for (int k = 0; k <next.length ; k++) {
                if (getWay2(map, i + next[k][0], j + next[k][1])) {
                    return  true;
                }
            }
            map[i][j] = 3;
        }else {
            return false;
        }
        return false;
    }
}
