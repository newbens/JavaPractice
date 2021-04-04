package shujujiegou;

public class Main {
    public static void main(String[] args) {
        int l = 3;
        int money = 10;
        int[][] map = {{2,2,3}, {1,5,10}, {2,4,12}};
        beibao(map,money);
    }

    public static void beibao(int[][] map,int money) {
        int[] dp = new int[money+1];
        dp[0] = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= money ; j++) {
                if (j >= map[i-1][1] && map[i-1][0] > 0) {
                    dp[j] = Math.max(dp[j], dp[j - map[i-1][1]] + map[i-1][2]);
                }
            }
        }
        System.out.println(dp[money]);
    }
}