package 阅文;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        int m, p, n;
        m = Integer.valueOf(split[0]);
        p = Integer.valueOf(split[1]);
        n = Integer.valueOf(split[2]);
        int[][] a = new int[m][p];
        int[][] b = new int[p][n];
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            String[] split1 = input.split(",");
            for (int j = 0; j < p; j++) {
                a[i][j] = Integer.valueOf(split1[j]);
            }
        }
        for (int i = 0; i < p; i++) {
            String input = sc.next();
            String[] split1 = input.split(",");
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.valueOf(split1[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int res = 0;
                for (int k = 0; k < p; k++) {
                    res += (a[i][k] * b[k][j]);
                }
                c[i][j] = res;
            }
        }
        for (int i = 0; i < m; i++) {
            String res = "";
            for (int j = 0; j < n; j++) {
                res += c[i][j] + ",";
            }
            System.out.println(res.substring(0,res.length()-1));
        }
    }
}
