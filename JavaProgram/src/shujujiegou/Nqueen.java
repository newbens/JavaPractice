package shujujiegou;

public class Nqueen {
    int max = 8;
    int[] res = new int[max];  //存放摆放位置
    static int count = 0;

    public static void main(String[] args) {
        new Nqueen().insert(0);
        System.out.println(count);
    }

    private void print() {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private void insert(int n) {
        if (n == max) {          //n == max代表前八个皇后已经放好了
            System.out.println("******");
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            res[n] = i;          //i代表皇后行标，n是第几个皇后
            if (check(n)) {      //如果返回true，这递归下一个皇后，不行返回for循环寻找新的位置
                insert(n + 1);
            }
        }
    }

    public boolean check(int n) {    //检测是否冲突  n代表第几个皇后
        for (int i = 0; i < n; i++) {
            //判断是否在同一列或者同意斜线
            if (res[i] == res[n] || Math.abs(n - i) == Math.abs(res[n] - res[i])) {
                return false;
            }
        }
        return true;
    }
}

