package cn.leetcode;

//求路径
public class Test12 {
    public static void main(String[] args) {
        boolean dfs = false;
        char[][] a = {{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word = "ABCCED";
        char[] words = word.toCharArray();
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a[0].length ; j++) {
                if(dfs(a, words, i, j, 0)){
                    System.out.println("true");
                    break;
                }
            }
        }
    }

    /**
     *
     * @param a    二维数组
     * @param word   代求字符串
     * @param i
     * @param j
     * @param k  word的下标
     * @return
     */
    public static boolean dfs(char[][] a,char[] word,int i,int j,int k) {
        //深度优先遍历
        if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || word[k] != a[i][j]) return false;
        if(k == word.length - 1) return true;
        char temp = a[i][j];
        a[i][j] = '*';
        boolean res = dfs(a, word, i + 1, j, k + 1) || dfs(a, word,i - 1, j, k + 1)
                || dfs(a, word, i, j + 1, k + 1) || dfs(a, word, i, j - 1, k + 1);
        a[i][j] = temp;
        return res;
    }

}
