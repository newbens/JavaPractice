package 建信;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args){
        int[] a = {2, 5,12};
        int b = 0;
        System.out.println(new Main1().carsTrans(a, b));
    }
    public int carsTrans (int[] cars, int num) {
        if(cars.length == 0 && num != 0)return -1;
        if(num == 0)return 0;
        if(cars.length == 0 && num != 0)return -1;
        int res = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            if (num >= cars[i]) {
                int n = num / cars[i];
                res += n;
                num -= n * cars[i];
            } else continue;
        }
        return num == 0 ? res : -1;
    }
}
