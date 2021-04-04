package shujujiegou.SuanFa;

public class ErFeng {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int res = getIndex2(a,5,0,a.length);
        System.out.println(res);
    }

    public static int getIndex(int[] a,int target) {  //·ÇµÝ¹é
        int left = 0, right = a.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static int getIndex2(int[] a,int target,int left,int right) {  //µÝ¹é
        int mid = (left + right)/2;
        if (a[mid] == target) {
            return mid;
        }else if (a[mid] > target) {
          return  getIndex2(a,target,left,mid-1);
        }else {
            return getIndex2(a, target, mid + 1, right);
        }
    }
}
