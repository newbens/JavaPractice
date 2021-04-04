package DIDI;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int a = 100 * i + 10 * j + k;
                    int b = 100 * i + 10 * k + k;
                    if((a+b) == n && i != 0 && i != j && j != k && i != k) {
                        count++;
                        int[] temp = {a,b};
                        list.add(temp);
                    }
                }
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            for (int j = 0; j < 2; j++) {
                System.out.print(ints[j]+" ");
            }
        }
    }
}
