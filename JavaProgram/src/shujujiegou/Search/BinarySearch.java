package shujujiegou.Search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 1,1,2,2, 5, 9, 10, 15, 16};
        ArrayList res = binarySearch(a,1,0,a.length-1);
        System.out.println(res);
    }
    public static ArrayList binarySearch(int[] a,int value,int left,int right){
        ArrayList res = new ArrayList();
        if (left > right) {
            return  new ArrayList();
        }
        int mid = (left + right) / 2;
        int midVlaue = a[mid];
        if (midVlaue > value) {
           return binarySearch(a, value, left, mid-1);
        }else if(midVlaue < value){
           return binarySearch(a, value, mid+1, right);

        }else{
            int temp = mid;
            while (temp >= 0 &&value == a[temp]) {
                res.add(temp);
                temp --;
            }
            mid += 1;
            while (value == a[mid] && mid<=right) {
                res.add(mid);
                mid ++;
            }
            return res;
        }
    }
}
