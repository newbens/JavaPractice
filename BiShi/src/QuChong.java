import java.util.Arrays;

public class QuChong {
    public static void main(String[] args){
        int[] a = {1,2,3,4,4,5,6,7};
        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != i + 1) {
//                System.out.println(a[i]);
//                break;
//            }
//        }
        System.out.println(test(a));
    }

    public static int test(int[] a) {
        int len = a.length;
        int le = 1;
        int ri = len - 1;
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            int count = 0;
            for (int i : a) {
                if (i <= mid) {
                    count += 1;
                }
            }
            if (count > mid) {
                ri = mid;
            }else {
                le = mid + 1;
            }
        }
        return le;
    }
}
