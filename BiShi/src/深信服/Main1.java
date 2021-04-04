package 深信服;

import java.util.*;

public class Main1 {
    public int maxCoins (int[] piles) {
        int n = piles.length;
        int alice = n-1, me = alice-1, bob = 0;
        Arrays.sort(piles);
        int res = 0;
        while (alice > bob) {
            res += piles[me];
            alice -= 2;
            me -= 2;
            bob += 1;
        }
        return res;
    }
}
