package SLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 5 6 1 5
 * 1 5 100
 * 1 2 10
 * 2 5 5
 * 1 3 3
 * 3 4 2
 * 4 5 1
 */
public class Main2 {
    static int res = Integer.MAX_VALUE;   //路径总嘲笑数
    static int maxHum = 0; //最大嘲笑数
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        Integer[][] a = new Integer[m][3];
        for (int i = 0; i < m; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }
        test(a, s, t, new ArrayList<>());
        System.out.println(maxHum);
    }

    public static void test(Integer[][] a,int s,int t,List<Integer> path) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == s) {
                list.add(a[i]);
            }
        }
        if(list.size() == 0) return;
        for (int i = 0; i < list.size(); i++) {
            Integer[] ints = list.get(i);
            if (ints[1] == t) {
                path.add(ints[2]);
                if (getSum(path) < res) {
                    res = getSum(path);
                    maxHum = getMax(path);
                }
                path.remove(ints[2]);
            }else {
                path.add(ints[2]);
                test(a, ints[1], t,path);
                path.remove(ints[2]);
            }
        }
    }

    public static int getSum(List<Integer> path) {  //求路径总嘲笑数
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i);
        }
        return sum;
    }

    public static int getMax(List<Integer> path) {  //求路径最大嘲笑数
        int max = 0;
        for (int i = 0; i < path.size(); i++) {
            max = Math.max(max, path.get(i));
        }
        return max;
    }



}
