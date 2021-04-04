package cn.leetcode;

public class Test33 {
    public static void main(String[] args) {
        int[] list = {5,1,3};
        int num = 5;
        int res = getIndex(list,num);
        System.out.println(res);
    }

    public static int getIndex(int[] list,int num) {
        int len = list.length;
        int left= 0,right = len-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == num) {
                return mid;
            }
            if (list[left] <= list[mid]) {//ËµÃ÷ÓĞĞò
                if (num >= list[left] && num < list[mid] ) {
                    right = mid-1;
                }else {
                    left = mid +1;
                }
            }else {
                if (num <= list[right] && list[mid] < num) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return  -1;
    }

}
