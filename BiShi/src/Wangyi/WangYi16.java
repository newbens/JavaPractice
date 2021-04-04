package Wangyi;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class WangYi16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n ; i++) {
            xy[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n ; i++) {
            xy[i][1] = sc.nextInt();
        }
        int count = 0;
        if(n < 4) count = n;
        else {
            for (int i = 0; i < n; i++) {  //先选取一个点
                for (int j = i+1; j < n; j++) { //在选取第二个点  两个点就确定了一个轴
                    int x1 = xy[i][0] - xy[j][0];
                    int y1 = xy[i][1] - xy[j][1];
                    for (int k = 0; k < n; k++) { //选取第三个点 确定 另一个轴
                        if(k == i || k == j) continue;
                        int sum = 3;
                        for (int l = 0; l < n; l++) {  //选取第四个点 如果这个点平行于其中一个轴或者垂直于另一个轴 就满足。
                            int x2 = xy[l][0] - xy[k][0];
                            int y2 = xy[l][1] - xy[k][1];
                            int x3 = xy[l][0] - xy[i][0];
                            int y3 = xy[l][1] - xy[i][1];
                            if(l == i || l== j || l== k) continue;
                            if(x1*x2+y1*y2 == 0 || x1*y3 == x3*y1){
                                sum ++;
                            }
                        }
                        count = Math.max(count, sum);
                    }
                }
            }
        }
        System.out.println(count);
    }
}