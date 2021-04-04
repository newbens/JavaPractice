package 永航;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int index = 0;
        int count = 1;
        String res = "";
        while (index < c.length) {
            count = 1;
            while (index+1 < c.length && c[index] == c[index+1]) {
                count++;
                index++;
            }
            res += c[index] + "_" + count+"_";
            index++;
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
