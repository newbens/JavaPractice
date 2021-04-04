package com.niuben;

public class Sub4 {
    public static void main(String[] args) {
//        System.out.println("请输入想要分解的数：");
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        decompose(a);
    }

    public void decompose(int a) {
        int temp = a /2;
        int counter = 0;
        System.out.print("因数有：");
        for (int i = 2; i <=temp ; i++) {
            if (a%i == 0){
                a = a/i;
                System.out.print(i+" ");
                i = 1;
                counter += 1;
                continue;
            }
        }
        if(counter == 0){
            System.out.print("0个");
        }
    }
    public int getnum(int a ) {
        return a;
    }

}
