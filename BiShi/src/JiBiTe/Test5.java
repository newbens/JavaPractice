package JiBiTe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] cs = s.toCharArray();
        String[] ss = new String[cs.length];
        for (int i = 0; i < cs.length; i++) {
            ss[i] = String.valueOf(cs[i]).toUpperCase();
        }
        String a = sc.next().toUpperCase();
        String b = sc.next().toUpperCase();
        List<Integer> aIndex = new ArrayList<>();
        List<Integer> bIndex = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals(a)) {
                aIndex.add(i);
            }
            if (ss[i].equals(b)) {
                bIndex.add(i);
            }
        }
        if( aIndex.size() == 0 || bIndex.size() == 0) System.out.println(-1);
        else {
            Integer mina = Collections.min(aIndex);
            Integer maxa = Collections.max(aIndex);
            Integer minb = Collections.min(bIndex);
            Integer maxb = Collections.max(bIndex);
            System.out.println(Math.max((maxa-minb),(maxb-mina)));
        }
    }

}
