package shujujiegou.SuanFa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TanXin {
    public static void main(String[] args) {
        HashMap<String, HashSet> broad = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("����");
        hashSet1.add("�Ϻ�");
        hashSet1.add("���");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("����");
        hashSet2.add("����");
        hashSet2.add("����");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("�ɶ�");
        hashSet3.add("�Ϻ�");
        hashSet3.add("����");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("���");
        hashSet4.add("�Ϻ�");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("����");
        hashSet5.add("����");
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
                temp.retainAll(all);   //�󽻼�
            }
        }
    }
}
