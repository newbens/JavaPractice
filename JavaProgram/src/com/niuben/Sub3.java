package com.niuben;

public class Sub3 {
    public static void main(String[] args) {
        System.out.print("水仙花数有：");
        for (int i = 100; i <1000 ; i++) {
            if (getNum(i)){
                System.out.print(i+" ");
            }

        }
    }
    public static boolean getNum(int n){
        int n1 = 0;  //百位
        int n2 = 0;  // 十位
        int n3 = 0;  // 个位
        n1 = (n/100);
        n2 = (n - n1*100) /10;
        n3 = n - n1*100 - n2*10;
        if (Math.pow(n1,3)+Math.pow(n2,3)+Math.pow(n3,3) == n){
            return true;
        }
        return false;
        }

    }


