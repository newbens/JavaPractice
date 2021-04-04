import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//  排列组合
public class Test {
    static int n = 0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        dfs("",list);
    }

    public static void dfs(String s, List<Integer> list) {
        if (s.trim().length() == 5) System.out.println(s);
        for (int i = 0;i < list.size();i++) {
            LinkedList<Integer> temp = new LinkedList<>(list);
            Integer remove = temp.remove(i);
            dfs(s+remove+" ",temp);
        }
    }
}
