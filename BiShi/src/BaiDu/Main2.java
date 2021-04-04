package BaiDu;
import java.util.*;
public class Main2 {
    static Set<Integer> winnerSet = new HashSet<>();
    static Set<Integer> loserSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i][0] = x;
            a[i][1] = y;
            if (x == p) {
                getLoser(a, x);
            }
            if (y == p) {
                getWinner(a, y);
            }
        }
        for (int i = winnerSet.size()+1; i <= n - loserSet.size(); i++) {
            System.out.print(i + " ");
        }
    }
    public static void getLoser(int[][] a, int id) {   //寻找手下败将
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == id) {
                loserSet.add(a[i][1]);
                getLoser(a, a[i][1]);
            }
        }
    }
    public static void getWinner(int[][] a, int id) {   //寻找战胜者
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] == id) {
                winnerSet.add(a[i][0]);
                getWinner(a, a[i][0]);
            }
        }
    }
}
