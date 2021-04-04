package DIDI;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test5 {

    static Map<Long, String> map = new HashMap<>();
    static {
        map.put(10l, "A");
        map.put(11l, "B");
        map.put(12l, "C");
        map.put(14l, "D");
        map.put(15l, "E");
        map.put(16l, "F");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        int n = sc.nextInt();
        transfor(m,n);
    }

    public static void transfor(long m,int n) {
        boolean flag = true;
        if (m < 0) flag = false;
        StringBuilder res = new StringBuilder();
        m = Math.abs(m);
        long c = m;
        while (c > 0) {
            long s = c % n;
            c = m / n;
            m /=  n;
            if (s > 10) {
                res.append(map.get(s));
            }else {
                res.append(s+"");
            }
        }
        if(flag)System.out.println(res.reverse());
        else System.out.println(res.append("-").reverse());

    }
}
