package MeiTuan;

import java.util.Scanner;

public class MeiTuan01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        int s1 = Integer.parseInt(n.substring(1, n.length()-1));
        int s2 = Integer.parseInt(m.substring(1, m.length()-1));
        int count = s1 + s2;
        System.out.println("\""+count+"\"");
    }
}
