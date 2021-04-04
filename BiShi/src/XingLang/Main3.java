package XingLang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public  class Main3 {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i + "");
            a[i-1] = i;
        }
        dfs("",list);
        dfs2(a,0,n-1);
    }

    public static void dfs(String s, List<String> list) {
        if (list.size() == 0) {
            System.out.println(s);
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> newList = new LinkedList<>(list);
            String remove = newList.remove(i);
            dfs(s+remove,newList);
        }
    }

    public static void dfs2(int[] a,int start,int end) {
        if (start == end) {
            System.out.println(Arrays.toString(a));
        }else {
            for (int i = start; i <= end; i++) {
                swap(a,start,i);
                dfs2(a,start+1,end);
                swap(a,start,i);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
