package BiLiBiLi;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        Arrays.sort(strings, (x, y) ->
            (x + y).compareTo(y + x)
        );
        String res = "";
        for (int i = 0; i < strings.length ; i++) {
            res += strings[i];
        }
        System.out.println(Long.valueOf(res));
    }
}
