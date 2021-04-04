package DIDI;


import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 桌子数
        int m = sc.nextInt(); // 个人批数
        int[] cap = new int[n];  //桌子容量
        for (int i = 0; i < n; i++) {
            cap[i] = sc.nextInt();
        }
        List<int[]> list = new ArrayList<>(); //客人信息
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new int[]{a, b});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int profit = 0;
        for (int i = 0; i < n; i++) {
            int ri = list.size() - 1;
            int le = 0;
            int mid = 0;
            while (le < ri) {
                mid = (le + ri) / 2;
                if (list.get(mid)[0] >= cap[i]) ri = mid - 1;
                else le = mid + 1;
            }
            if (le == 0 && list.get(le)[0] > cap[i]) {
                profit += 0;
                break;
            } else {
                while (le < list.size() && list.get(le)[0] <= cap[i]) {
                    le++;
                }
            }
            le--;
            profit += list.get(le)[1];
            list.remove(le);
        }
        System.out.println(profit);
    }
}

