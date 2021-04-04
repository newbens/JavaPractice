package cn.leetcode.offer;

public class Test67 {
    public static void main(String[] args) {
        String s = " ";
        Integer integer = StrToInt(s);
        System.out.println(integer);
    }

    public static Integer StrToInt(String s) {
        String help = "1234567890+-";
        int f = 1;
        StringBuilder res = new StringBuilder();
        char[] chars = s.trim().split(" ")[0].toCharArray();
        if(chars.length == 0)return 0;
        if(!help.contains(String.valueOf(chars[0]))){
            return 0;
        }else if(chars[0] == '-'){
            f = -1;
        }
        else if(chars[0] == '+'){
        }else {
            res.append(chars[0]);
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '-' || chars[i] == '+' || !help.contains(String.valueOf(chars[i]))) {
                break;
            }
            res.append(chars[i]);
        }
        if (res.length() == 1) {
            if(res.toString().equals("+") || res.toString().equals("-"))return 0;
        }
        double num = 0;
        for (int i = res.length()-1; i >= 0 ; i--) {
            num += (Integer.valueOf(res.substring(i,i+1))) * Math.pow(10, res.length()-1-i);
        }
        if((f*num) >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if((f*num) <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)(f*num);
    }
}
