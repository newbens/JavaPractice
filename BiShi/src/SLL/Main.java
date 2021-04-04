package SLL;

import java.util.Scanner;

//360
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();  //物体数
            int b = sc.nextInt();  //隔板数
            int k = sc.nextInt();  //最多隔间数
            int v = sc.nextInt();  //每个隔间最多数
            System.out.println(test(a, b, k, v));
        }
    }

    public static int test(int a,int b,int k,int v) {
        int count = 0;
        while (b > 0) {
            if(b < k){
                a -= (b + 1) * v;
                count++;
                break;
            }else {
                a -= k * v;
                count += 1;
                b -= (k - 1);
                if(a <= 0) break;
            }
        }
        while (a > 0) {
            a -= v;
            count++;
        }
        return count;
    }
}
