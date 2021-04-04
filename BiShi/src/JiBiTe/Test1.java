package JiBiTe;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String n = "";
        String c = "";
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i] >= 97) c += chars[i];
            else n += chars[i];
        }
        System.out.println(n+c);
    }
}
