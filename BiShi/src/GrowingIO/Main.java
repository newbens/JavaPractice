package GrowingIO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String all = "qazwsxedcrfvtgbyhnujmikolp";
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;
        int n = sc.nextInt();
        while (n > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            String[] sp1 = s1.split("");
            String[] sp2 = s2.split("");
            if (s2.length() == 0) {
                System.out.println("YES");
            }else if (sp1.length < sp2.length) {
                System.out.println("NO");
            } else {
                while (x < sp1.length && y < sp2.length) {
                    if (sp1[x].equals(sp2[y])) {
                        x++;
                        y++;
                    }else {
                        if (!all.contains(sp1[x])) {
                            break;
                        }else {
                            if (sp1[x].toUpperCase().equals(sp2[y])) {
                                x++;
                                y++;
                            }else {
                                x++;
                            }
                        }
                    }
                }
                if (y == sp2.length) System.out.println("YES");
                else System.out.println("NO");
                n--;
            }
        }
    }
}
