package cn.leetcode;

import java.util.Arrays;

public class Test130 {

    public static void main(String[] args) {
        char[][] board = {{'x','x','x','x'},{'x','o','o','x'},{'x','x','o','x',},{'x','o','x','x'}};
        new Test130().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
        public void solve(char[][] board) {
            int x = board.length;
            int y = board[0].length;
            boolean[][] help = new boolean[x][y];
            for(int i = 0;i < y;i++){
                if(board[0][i] == 'o')dfs(0,i,help,board);
            }
            for(int i = 0;i < y;i++){
                if(board[x-1][i] == 'o')dfs(x-1,i,help,board);
            }
            for(int i = 0;i < x;i++){
                if(board[i][0] == 'o')dfs(i,0,help,board);
            }
            for(int i = 0;i < x;i++){
                if(board[i][y-1] == 'o')dfs(i,y-1,help,board);
            }
            System.out.println(Arrays.deepToString(help));
            for(int i = 0; i < x;i ++){
                for(int j = 0;j < y;j++){
                    if( !help[i][j]  && board[i][j] == 'o'){
                        board[i][j] = 'x';
                    }
                }
            }

        }
        public void dfs(int i,int j,boolean[][] help,char[][] board){
            if(i < 0 ||j <0 || i >board.length-1 || j > board[0].length -1 || board[i][j] == 'x' || help[i][j] == true)return;
            help[i][j] = true;
            dfs(i+1,j,help,board);
            dfs(i-1,j,help,board);
            dfs(i,j+1,help,board);
            dfs(i,j-1,help,board);
        }
}
