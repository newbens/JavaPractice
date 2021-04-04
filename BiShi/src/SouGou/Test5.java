package SouGou;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        int a = Integer.valueOf(split[0]);
        int b = Integer.valueOf(split[1]);
        int c = Integer.valueOf(split[2]);
        int res = numberofprize(a, b, c);
        System.out.println(res);
    }

    public static int numberofprize(int a, int b, int c) {
        int[] list = new int[3];
        list[0] = a;
        list[1] = b;
        list[2] = c;
        while (true) {
            Arrays.sort(list);
            if((list[0] == list[1] && list[2] - list[1] == 2) || (list[2] - list[1] + list[1] - list[0] < 2)) break;
            if (list[2] == list[1]) {
                list[2]--;
                list[1]--;
                list[0]++;
            }
            if (list[2] - list[0] > 2) {
                list[2] = list[2] - 2;
                list[0] = list[0] + 1;
                continue;
            }
            if (list[2] - list[1] > 2) {
                list[2] = list[2] - 2;
                list[0] = list[0] + 1;
                continue;
            }
            if (list[1] - list[0] > 2) {
                list[1] = list[1] - 2;
                list[0] = list[0] + 1;
                continue;
            }
        }
        return list[0];
    }
}

