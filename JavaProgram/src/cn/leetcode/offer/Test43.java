package cn.leetcode.offer;

/**
 * �ߵ�λ����
 *      2301 ���� cur=0��high��=23��low��=1����ʱ����1�ĸ���Ϊ  high*cur��
 *      2311 ���� cur=1��high��=23��low��=1����ʱ����1�ĸ���Ϊ  high*cur+low+1��
 *      2321 ���� cur>1��high��=23��low��=1����ʱ����1�ĸ���Ϊ  (high+1)*low��
 */
public class Test43 {
    public static void main(String[] args) {
        int num = 12;
        int nums = slove(num);
        System.out.println(nums);
    }

    public static int slove(int num) {
        int digit = 1,res = 0;
        int high = num/10,cur = num%10,low=0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high*digit;
            } else if (cur == 1) {
                res += (high*digit+low+1);
            }else {
                res += (high+1)*digit;
            }
            low += digit * cur;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
