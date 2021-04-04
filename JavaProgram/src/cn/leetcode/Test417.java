package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//̫ƽ����ˮ����
public class Test417 {
    public static void main(String[] args) {
        int[][] m = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        List<List<Integer>> slove = new Test417().slove(m);
        System.out.println(slove);
    }

    public List<List<Integer>> slove(int[][] m) {
        if(m.length == 0 || m[0].length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int x = m.length;
        int y = m[0].length;
        int[][] a = new int[x][y]; //̫ƽ������ͨ�ľ���
        int[][] b = new int[x][y]; //����������ͨ�ľ���
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y ; j++) {
                if(i == 0 || j == 0){
                    dfs(m,a,i,j,m[i][j]);
                }
                if(i == x -1 || j == y-1){
                    dfs(m,b,i,j,m[i][j]);
                }
            }
        }
        for (int i = 0; i < x ; i++) { //����������ͨ�ĵط����ǽ��
            for (int j = 0; j < y ; j++) {
                if (a[i][j] == 1 && b[i][j] == 1) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] m,int[][] t,int i,int j,int pre) { //����˼�� ������ͨ�ĵط������Ϊ1
        if (i < 0 || j < 0 || i >= m.length || j >= m[0].length || t[i][j] == 1 || m[i][j] < pre) return;
        t[i][j] = 1;
        dfs(m,t,i+1,j,m[i][j]);
        dfs(m,t,i-1,j,m[i][j]);
        dfs(m,t,i,j+1,m[i][j]);
        dfs(m,t,i,j-1,m[i][j]);
    }
}
