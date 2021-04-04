package ALiBaBa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) System.out.println(1);
        else if(n==2) System.out.println(3);
        else {
            long res = n + 1;
            for (int i = 2; i < n; i++) {
                res += n;
            }
            System.out.println(res);
        }
    }
}
