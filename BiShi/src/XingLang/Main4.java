package XingLang;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args){
        int[] a = {1, 2, 3};
        List<List<Integer>> test = test(a);
        System.out.println(test);
    }

    public static List<List<Integer>> test(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (a == null || a.length == 0) {
            return res;
        }
        for (int i = 0; i < a.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(a[i]);
                res.add(cur);
            }
        }
        return res;
    }
}
