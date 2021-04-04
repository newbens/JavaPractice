package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

public class HuaWei03 {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 10);
        hashMap.put('B', 11);
        hashMap.put('C', 12);
        hashMap.put('D', 13);
        hashMap.put('E', 14);
        hashMap.put('F', 15);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int res = 0;
            String s = in.next();
            String str = s.substring(2, s.length()); //去除字符串头
            char[] chars = str.toCharArray();
            int len = chars.length;
            int step = 0;
            for (int i = len-1; i >= 0 ; i--) {
                if (hashMap.containsKey(chars[i])) {
                    res += (hashMap.get(chars[i])) * Math.pow(16, step++);
                }else {
                    res += Integer.valueOf(String.valueOf(chars[i])) * Math.pow(16, step++);
                }
            }
            System.out.println(res);
        }
    }
}