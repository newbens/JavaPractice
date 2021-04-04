package HuaWei;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HuaWei06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split("-");
        String[] a = strings[0].split(" ");
        String[] b = strings[1].split(" ");
        String[] card = {"3", "4", "5","6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 15 ; i++) {
            map.put(card[i], i);
        }
        if(show(a).equals("joker JOKER") || show(b).equals("joker JOKER")) System.out.println("joker JOKER");
        else {
            if(b.length != 4 && a.length != 4 && (b.length != a.length)) System.out.println("ERROR");
            else {
                if(a.length == 4 && b.length != 4) System.out.println(show(a));
                else if(b.length == 4 && a.length != 4) System.out.println(show(b));
                else {
                    Integer i = map.get(a[0]);
                    Integer j = map.get(b[0]);
                    if(i < j) System.out.println(show(b));
                    else System.out.println(show(a));
                }
            }
        }
    }


    public static String show(String[] strings) {
        String res = "";
        for (int s = 0; s < strings.length; s++) {
            res += (strings[s] + " ");
        }
        return res.trim();
    }
}
