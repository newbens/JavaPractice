import java.util.Scanner;

public class Hanota {
    static int time;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hano(n,'a','b','c');
    }
    public static void hano(int n,char a,char b,char c) {
        if(n == 1){
            move(n,a,c);
        }else {
            hano(n-1,a,c,b);
            move(n,a,c);
            hano(n-1,b,a,c);
        }
    }
    public static void move(int pan,char s,char e) {
        System.out.println("第"+(++time)+"次移动,盘子"+pan+"   "+s+"   ->    "+e);
    }
}
