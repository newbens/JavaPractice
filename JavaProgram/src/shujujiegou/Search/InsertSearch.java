package shujujiegou.Search;

import java.util.ArrayList;

public class InsertSearch extends BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList res = insertSearch(a, 1, 0, a.length - 1);
        System.out.println(res);
    }
    public static ArrayList insertSearch(int[] a, int value, int left, int right){
        ArrayList res = new ArrayList();
        if (left > right || value<a[0] || value > a[a.length-1]) {
            return  new ArrayList();
        }
        int mid = left + (right - left) * (value - a[left]) / (a[right] - a[left]);
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
