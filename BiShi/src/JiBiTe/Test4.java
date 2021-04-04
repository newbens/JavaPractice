package JiBiTe;


import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(m);
        int i = s1.length();
        int j = s2.length();
        int res = 0;
        while (i > 0 && j > 0) {
            String a = s1.substring(i - 1, i);
            String b = s2.substring(j - 1, j);
            if(!a.equals(b)){
                res++;
            }
            i --;
            j --;
        }
        while (j > 0){
            if(s2.substring(j-1,j).equals("1")) res++;
            j--;
        }
        while (i > 0){
            if(s1.substring(i-1,i).equals("1")) res++;
            i--;
        }
        System.out.println(res);
    }

}
