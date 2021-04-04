package shujujiegou.SuanFa;

public class Hano {
    public static void main(String[] args) {
        hano(5, 'A','B','C');
    }

    public static void hano(int num,char a,char b,char c) {
        if (num == 1) {
            System.out.println("将第1个盘："+a+"->"+c);
        }else {
            //将除了最后一块的搜友盘看成一个移动从a移动到b
            hano(num-1,a,c,b);
            System.out.println("将第"+num+"个盘: "+a+"->"+c);
            hano(num-1,b,a,c);
        }
    }
}
