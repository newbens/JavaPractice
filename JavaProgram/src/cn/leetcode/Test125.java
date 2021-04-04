package cn.leetcode;

//验证回文串
public class Test125 {
    public static void main(String[] args) {
        String s = "OP";
        String help = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i<j && !help.contains(s.substring(i,i+1))) {
                i ++;
            }
            while (i<j && !help.contains(s.substring(j,j+1))) {
                j --;
            }
            if (!(s.substring(i,i+1).equalsIgnoreCase(s.substring(j,j+1)))){
                System.out.println("false");
                break;
            }
            i ++;
            j -- ;
        }

    }
}
