package SouGou;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//map大小
        sc.nextLine();
        Map<String, Long> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int num = 0;
        while (sc.hasNext()) {
            String[] split = sc.nextLine().split(" ");
            String key = split[0];
            Long val = Long.valueOf(split[1]);
            if (map.containsKey(key)) { //如果存在
                Long oldVal = map.get(key);
                if (oldVal <= val) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(key)) {
                            list.remove(i);
                        }
                    }
                    map.put(key, val);
                    list.add(key);
                    System.out.println(key+" "+oldVal);
                }
            }else { //如果不存在
                if(num < n){ //map有空间
                    map.put(key, val);
                    num++;
                    list.add(key);
                }else { //map没有空间
                    String s1 = list.get(0);
                    Long oldVar = map.get(s1);
                    System.out.println(s1+" "+oldVar);
                    list.remove(0);
                    map.remove(s1);
                    map.put(key, val);
                    list.add(key);
                }
            }
        }
    }

}
