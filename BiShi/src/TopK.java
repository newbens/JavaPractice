
import java.util.LinkedList;

public class TopK { //找到最大的和第二大的
    public static void main(String[] args){
        int[] a = {8,7,6,5,4,3,2,1};
        int k = 2;
        test(a,k);
    }

    public static void test(int[] a,int k) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (list.size() == 1) {
                if (a[i] > list.get(0)) {
                    list.addFirst(a[i]);
                }else {
                    list.addLast(a[i]);
                }
            }else {
                if (a[i] > list.getFirst()) {
                    list.removeLast();
                    list.addFirst(a[i]);
                }else {
                    if (a[i] > list.getLast()) {
                        list.removeLast();
                        list.addLast(a[i]);
                    }else continue;
                }
            }
        }
        System.out.println(list);
    }

    public static void buildHeap(int[] a,int start,int end) {
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if(child > end) break;
            if (child + 1 <= end && a[child+1] > a[child]) child++;
            if (a[child] > a[end]) {
                int t = a[child];
                a[child] = a[root];
                a[root] = t;
                root = child;
            }else break;
        }

    }
}
