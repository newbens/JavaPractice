package 携程;

import java.util.*;

/**
 * 4
 * cc dd
 * aa bb
 * dd ee
 * bb cc
 */
public class Test1 {
    static String res;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] a = new String[4][2];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            String y = sc.next();
            a[i][0] = x;
            a[i][1] = y;
            map.put(x, 0);
            map.put(y, 0);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i][1])) {
                map.remove(a[i][1]);
            }
        }
        for (String s : map.keySet()) {
            res = s;
        }
        test(res,a);
        System.out.println(res);

    }
    public static void test(String s,String[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][0].equals(s)) {
                res += " "+a[i][1] + " ";
                test(a[i][1],a);
            }
        }
    }
}
