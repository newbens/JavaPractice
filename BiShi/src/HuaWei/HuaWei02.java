package HuaWei;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HuaWei02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[1000];
        while (in.hasNext()) {
            int len = in.nextInt();
            for (int j = 0; j < 1000; j++)//初始化数组，为了应对你要在此输入新的数据时长度不一致
                num[j] = 0;
            for (int h = 0; h < len; h++) {
                int tar = in.nextInt();
                num[tar] = tar;       //输入的数据对应了相应的下标，就等于排序好了
            }
            for (int k = 0; k < 1000; k++) {
                if (num[k] == 0) {   //有空格的时候不需要干啥
                    //这里需要括号，为了表明你啥也不干
                } else
                    System.out.println(num[k]);
            }
        }
        in.close();

    }

}