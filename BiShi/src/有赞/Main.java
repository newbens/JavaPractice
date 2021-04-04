package 有赞;

import java.util.ArrayList;
import java.util.List;

public class Main {
    long res = 0;
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(0);
        System.out.println(new Main().largestMultipleOfThree(list));
    }

    public String largestMultipleOfThree (ArrayList<Integer> digits) {
        dfs("", digits);
        return res + "";
    }
    public void dfs(String s, List<Integer> list) {
        if (!s.equals("") &&Long.valueOf(s) % 3 == 0) {
            res = Math.max(res,Long.valueOf(s));
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>(list);
            Integer remove = temp.remove(i);
            dfs(s+remove,temp);
        }
    }
}
