package shujujiegou.SuanFa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TanXin {
    public static void main(String[] args) {
        HashMap<String, HashSet> broad = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broad.put("K1", hashSet1);
        broad.put("K2", hashSet2);
        broad.put("K3", hashSet3);
        broad.put("K4", hashSet4);
        broad.put("K5", hashSet5);
        HashSet<String> all = new HashSet<>();
        HashSet<String> temp = new HashSet<>();
        for (HashMap.Entry<String, HashSet> entry : broad.entrySet()) {
            Object[] s = entry.getValue().toArray();
            for (Object s1 : s) {
                all.add((String) s1);
            }
        }
        List<String> list = new ArrayList<>();
        while (all.size() != 0) {
            for (String key : broad.keySet()) {
                HashSet<String> a = broad.get(key);
                temp.addAll(a);
                temp.retainAll(all);   //求交集
            }
        }
    }
}
