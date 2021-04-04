package BaiDu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        String s = sc.next();
        for (int i = 0; i < a.length; i++) {
            a[i] = s.charAt(i);
        }
        int i = 0;
        int step = 0;
        while (i < a.length-1) {
            int j = a.length - 1;
            while (i < j && a[i] != a[j]) {
                j--;
            }
            if (i == j) {  //说明只能往后走一步了
                i++;
            }else {
                i = j;
            }
            step++;
        }
        System.out.println(step);
    }
}
