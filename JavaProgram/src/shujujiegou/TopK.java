package shujujiegou;

import java.util.Arrays;
import java.util.Scanner;

public class TopK {
    //TopKŒ Ã‚
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] a = new int[split.length];
        for (int i = 0; i <split.length ; i++) {
            a[i] = Integer.valueOf(split[i]);
        }
        int n = sc.nextInt();
        sort(n,a);

    }

    public static void buildHeap(int[] a,int start,int end) {
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if(child > end) break;
            if(child + 1 <= end && a[child+1] > a[child]) child++;
            if (a[child] > a[root]) {
                int temp = a[child];
                a[child] = a[root];
                a[root] = temp;
                root = child;
            } else break;
        }
    }

    public static void sort(int n,int[] a) {
        for (int i = a.length/2-1; i >=0; i--) {
            buildHeap(a,i,a.length-1);

        }
        for (int i = a.length-1; i > a.length-n-1; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            buildHeap(a,0,i-1);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(a[a.length-n]);
    }
}
