package c;

//∆Ê∞≤–≈ ±  ‘Ã‚2
import java.util.*;

public class Test2 {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Integer[] a = {1, 1, 2};
        int count = 0;
        List<Integer> list = Arrays.asList(a);
        new Test2().dfs("", a.length, list);
        for (Integer integer : set) {
            System.out.println(integer);
            if(integer % 7 == 0) count++;
        }
        System.out.println(count);
    }

    public void dfs(String s, int len, List<Integer> list) {
        if (s.length() == len) {
            set.add(Integer.valueOf(s));
        }
        for (int i = 0; i < list.size(); i++) {
            LinkedList<Integer> temp = new LinkedList<>(list);
            Integer remove = temp.remove(i);
            dfs(s + remove, len, temp);
        }
    }
}

