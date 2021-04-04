package BiLiBiLi;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split("\\s+");
        String res = "";
        for (int i = strings.length-1; i >= 0  ; i--) {
            res += (strings[i] + " ");
        }
        System.out.println(res);
    }
}
