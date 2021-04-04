package 携程;

public class Main {
    public static void main(String[] args) {
        System.out.println(buyCoke(3, 1, 4, 3, 150));
    }

    public static int buyCoke(int m, int a, int b, int c, int x) {
        int step = 0;
        while (m > 0) {
            int t = x;
            int count = 0;
            while (c > 0 && t > 0) {    //有100用100
                count++;
                c--;
                t -= 100;
            }
            while (b > 0 && t > 0) {    //有50用50
                count++;
                b--;
                t -= 50;
            }
            while (a > 0 && t > 0) {    //有10用10
                count++;
                a--;
                t -= 10;
            }
            m--;
            step += count;
            if (t == 0) continue;
            else {
                int temp = -t;
                while (temp >= 50) {
                    b++;
                    temp -= 50;
                }
                while (temp >= 10) {
                    a++;
                    temp -= 10;

                }
            }
        }
        return step;
    }
}
