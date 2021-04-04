package 天融信;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        String reslove = reslove(chars);
        System.out.println(reslove);
    }

    public static String reslove(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length-1-i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char t = chars[j];
                    chars[j] = chars[j+1];
                    chars[j + 1] = t;
                }
            }
        }
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res += chars[i];
        }
        return res;
    }
}
