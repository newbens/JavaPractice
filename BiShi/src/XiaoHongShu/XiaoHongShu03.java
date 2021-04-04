package XiaoHongShu;

import java.util.Scanner;


public class XiaoHongShu03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        solve(s);
    }

    public static void solve(String s) {
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                continue;
            }
            if (count != 0) {
                if (s.charAt(i) == ')') {
                    count --;
                }
                continue;
            }
            if (s.charAt(i) == '<') {
                res.deleteCharAt(res.length() - 1);
                continue;
            }
            res.append(s.charAt(i));
        }
        System.out.println(res);
    }
}
