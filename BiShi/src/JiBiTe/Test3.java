package JiBiTe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if(o1[1] == o2[1]) return o1[2] - o2[2];
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int res = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i +1; j < n; j++) {
                int x = a[i][0] - a[j][0];
                int y = a[i][1] - a[j][1];
                int z = a[i][2] - a[j][2];
                int count = 2;
                for (int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    int newX = a[k][0] - a[i][0];
                    int newY = a[k][1] - a[i][1];
                    int newZ = a[k][2] - a[i][2];
                    if(newX*y == newY*x && newZ*x == newX*z && newY*z == newZ*y){
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        System.out.println(res);
    }
}
