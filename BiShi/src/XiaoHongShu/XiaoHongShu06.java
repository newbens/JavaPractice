package XiaoHongShu;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class XiaoHongShu06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                flag++;
                continue;
            }
            if (flag != 0) {
                if (chars[i] == ')') {
                    flag--;
                }
                continue;
            }
            if (chars[i] == '<') {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }
}
