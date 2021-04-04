package QIAnXin;


import java.util.*;

//全排列问题
public class QiAnXin02 {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Integer[] a = {1, 1, 2};
        List<Integer> list = Arrays.asList(a);
        new QiAnXin02().dfs("",a.length,list);
        for (Integer integer : set) {
            if (integer % 7 == 0) {
                System.out.println(integer);
            }
        }
        new QiAnXin02().dfs2(a,0,a.length-1);
    }

    public void dfs(String s, int len, List<Integer> list) {
        if (s.length() == len) {
            set.add(Integer.valueOf(s));
        }
        for (int i = 0;i < list.size();i++) {
            LinkedList<Integer> temp = new LinkedList<>(list);
            Integer remove = temp.remove(i);
            dfs(s+remove,len,temp);
        }
    }

    public void dfs2(Integer[] a,int start,int end) {
        if (start == end) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = start; i <= end ; i++) {
            swap(a, start, i);
            dfs2(a,start+1,end);
            swap(a, start, i);
        }
    }

    public void swap(Integer[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
