package shengzhou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args){
        String a = "19 5 9 255";
        test(a);
    }

    public static void test(String a) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] s = a.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            map.put(Integer.parseInt(s[i]), i);
        }
        Arrays.sort(arr);
        int in = map.size();
        int count = 0;
        for (int i = 0; i < map.size()-1; i++) {
            if (map.get(arr[i]) > map.get(arr[i + 1])) {
                map.put(arr[i + 1], in++);
                count++;
            }
        }
        System.out.println(count);
    }
}
