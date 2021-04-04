package GoWhere;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            set.add(str.substring(0, 1));
            s[i] = str.substring(1, str.length());
        }
        int[] list = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("J")) {
                list[i] = 11;
            } else if (s[i].equals("Q")) {
                list[i] = 12;
            } else if (s[i].equals("K")) {
                list[i] = 13;
            } else if (s[i].equals("A")) {
                list[i] = 14;
            } else {
                list[i] = Integer.valueOf(s[i]);
            }
        }
        String[] res = {"HuangJiaTongHuaShun", "TongHuaShun",
                "SiTiao", "HuLu", "TongHua", "ShunZi", "SanTiao",
                "LiangDui", "YiDui", "GaoPai"};
        Arrays.sort(list);
        if (check(list) && list[list.length - 1] == 14 && set.size() == 1) System.out.println(res[0]);//A同花顺
        else if (check(list) && set.size() == 1) System.out.println(res[1]);//同花顺
        else if (checktiao(list) == 4) System.out.println(res[2]);
        else if (checktiao(list) == 3) System.out.println(res[3]);
        else if (set.size() == 1) System.out.println(res[4]);
        else if (check(list)) System.out.println(res[5]);
        else if (checktiao(list) == 5) System.out.println(res[6]);
        else if (checktiao(list) == 6) System.out.println(res[7]);
        else if (checktiao(list) == 7) System.out.println(res[8]);
        else if (checktiao(list) == 8) System.out.println(res[9]);
        else System.out.println("");
    }


    public static boolean check(int[] a) {  //检测是否是同花
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1] - 1) continue;
            else return false;
        }
        return true;
    }

    public static int checktiao(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                Integer integer = map.get(a[i]);
                map.put(a[i], integer + 1);
            }
        }
        if (map.size() == 2) {
            for (Integer integer : map.keySet()) {
                Integer integer1 = map.get(integer);
                if (integer1 == 4) {
                    return 4;  //代表四带一单
                }
                if (integer1 == 3) {
                    return 3; //代表三条一对
                }
            }
        } else if (map.size() == 3) {
            for (Integer integer : map.keySet()) {
                Integer integer1 = map.get(a[integer]);
                if (integer1 == 3) {
                    return 5; //代表三条带两单
                }
            }
            return 6;//两对带一单
        } else if (map.size() == 4) return 7;//一对带三单
        else return 8;//五张单
        return 0;
    }
}