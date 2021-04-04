package SouGou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        int res = 2;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        double n = Double.valueOf(s.substring(0, 1));
        String[] ss = s.substring(3, s.length() - 1).split(",");
        int len = ss.length;
        List<Double> a = new ArrayList<>();  //中心坐标
        List<Double> b = new ArrayList<>();  //直径
        for (int i = 0; i < len ; i++) {
            if (i % 2 == 0) {
                a.add(Double.valueOf(ss[i]));
            } else b.add(Double.valueOf(ss[i]));
        }
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < a.size()-1 ; i++) {
            double index = a.get(i);
            double r = b.get(i);
            index += r / 2;
            double index2 = a.get(i + 1);
            double r2 = b.get(i+1);
            index2 -= r2 / 2;
            if (n < (index2 - index)) {
                res += 2;
            } else if (n == (index2 - index)) {
                res += 1;
            }
        }
        System.out.println(res);
    }
}
