package cn.leetcode.offer;

//кЁвс
public class Test61 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 6};
        boolean slove = slove(a);
        System.out.println(slove);
    }

    public static boolean slove(int[] a) {
        int joker = 0;
        for (int i = 0; i < a.length ; i++) {
            if(a[i] == 0) joker++;
            else {
                if(a[i] == a[i-1]) return false;
            }
        }
        return a[4] - a[joker] < 5;
    }
}
