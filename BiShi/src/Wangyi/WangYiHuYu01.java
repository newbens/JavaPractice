package Wangyi;

import java.util.*;

public class WangYiHuYu01 {
    static String[][] table = {
            {"1W", "4W", "7W", "2B", "5B", "8B", "3T", "6T", "9T"},
            {"1W", "4W", "7W", "2T", "5T", "8T", "3B", "6B", "9B"},
            {"1T", "4T", "7T", "2W", "5W", "8W", "3B", "6B", "9B"},
            {"1T", "4T", "7T", "2B", "5B", "8B", "3W", "6W", "9W"},
            {"1B", "4B", "7B", "2T", "5T", "8T", "3W", "6W", "9W"},
            {"1B", "4B", "7B", "2W", "5W", "8W", "3T", "6T", "9T"},
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < table[i].length; j++) {
                list.add(table[i][j]);
            }
            lists.add(list);
        }
        for (int i = 0; i < T; i++) {
            String[] strs = scanner.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for (int j = 0; j < strs.length; j++) {
                list.add(strs[j]);
            }
            Set<String> set =new HashSet<>();
            set.addAll(list);
            if(set.size()!=7) {
                System.out.println("NO");
                continue;
            }
            int flag = 0;
            for (int j = 0; j < lists.size(); j++) {
                if (lists.get(j).containsAll(list)) {
                    System.out.println("YES");
                    flag = 1;
                }

            }
            if (flag == 0)
                System.out.println("NO");
        }
    }
}

