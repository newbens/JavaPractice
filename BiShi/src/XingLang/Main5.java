package XingLang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main5 {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int n = 3;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        test(list,n);
        System.out.println(list);
    }

    public static void test(List<Integer> list,int n) {
        Collections.reverse(list.subList(list.size()-n,list.size()));
        Collections.reverse(list.subList(0,list.size()-n));
        Collections.reverse(list);
    }
}
