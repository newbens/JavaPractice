package 阅文;

public class Main1 {
    public int countBit (int n) {
        int res = 0;
        while (n != 0) {
            if((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }
}
