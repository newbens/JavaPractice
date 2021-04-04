package cn.leetcode;
//ЧѓзгађСа
public class Test446 {
    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        int res = solve(s1, n1, s2, n2);
        System.out.println(res);
    }

    public static int solve(String s1,int n1,String s2,int n2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int num1 = 0,num2 = 0,index = 0;
        while (num1 < n1) {
            for (int i = 0; i <s1.length() ; i++) {
                if (ss1[i] == ss2[index]) {
                    if (index == ss2.length - 1) {
                        index = 0;
                        num2++;
                    }else{
                        index ++;
                    }
                }
            }
            num1 ++;
        }

    return num2/n2;
    }
}
