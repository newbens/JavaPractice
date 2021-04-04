package 用友;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args){
      String[] ss = {"nice","try","duck","zoo"};
        String[] strings = new Main1().select_sort(ss);
        System.out.println(Arrays.toString(ss));
    }
    public String[] select_sort (String[] a) {
        for (int i = 0; i < a.length; i++) {
            String temp = a[i];
            int index = i;
            for (int j = i+1; j <a.length ; j++) {
                if (getFrist(a[j]) < getFrist(temp)) {
                    temp = a[j];
                    index = j;
                }
            }
            if (index != i) {
                a[index] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    public char getFrist(String s) {
        return s.charAt(0);
    }
}
