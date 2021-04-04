package shujujiegou.Sort;

//πÈ≤¢≈≈–Ú£°£°£°£°£°£°£°£°£°£°£°£°£°
public class MergeSort {
    static int number = 0;

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        printArray("≈≈–Ú«∞£∫", a);
        MergeSort(a);
        printArray("≈≈–Ú∫Û£∫", a);
    }

    private static void printArray(String pre, int[] a) {
        System.out.print(pre + "\n");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }

    private static void MergeSort(int[] a) {
        // TODO Auto-generated method stub
        System.out.println("ø™ º≈≈–Ú");
        merge(a, 0, a.length - 1);
    }
    private static void merge(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        merge(a, left, mid);
        merge(a, mid + 1, right);
        sort(a, left, mid, right);
    }
    private static void sort(int[] a, int left, int mid, int right) {
        int[] help = new int[a.length];
        int index = left;
        int start = left;
        int r = mid + 1;
        while (left <= mid && r <= right){
            if (a[left] > a[r]) {
                help[index++] = a[r++];
            }else {
                help[index++] = a[left++];
            }
        }
        while (left <= mid) {
            help[index++] = a[left++];
        }
        while (r <= right) {
            help[index++] = a[r ++];
        }
        while (start <= right) {
            a[start] = help[start];
            start++;
        }
    }
}


