package shujujiegou.SuanFa;

public class Hano {
    public static void main(String[] args) {
        hano(5, 'A','B','C');
    }

    public static void hano(int num,char a,char b,char c) {
        if (num == 1) {
            System.out.println("����1���̣�"+a+"->"+c);
        }else {
            //���������һ��������̿���һ���ƶ���a�ƶ���b
            hano(num-1,a,c,b);
            System.out.println("����"+num+"����: "+a+"->"+c);
            hano(num-1,b,a,c);
        }
    }
}
