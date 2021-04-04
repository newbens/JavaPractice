package cn.leetcode.offer;

/**
 * 高低位运算
 *      2301 假设 cur=0，high就=23，low就=1，此时含有1的个数为  high*cur。
 *      2311 假设 cur=1，high就=23，low就=1，此时含有1的个数为  high*cur+low+1。
 *      2321 假设 cur>1，high就=23，low就=1，此时含有1的个数为  (high+1)*low。
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
