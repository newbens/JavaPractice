package cn.leetcode;

//ÄæĞò¶Ô
public class Test51 {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        int len = nums.length;
        int res = get(nums, 0, len-1);
        System.out.println(res);

    }

    private static int get(int[] nums ,int left,int right) {
        if (left >= right)return 0;
        int mid = left + (right - left) / 2;
        int leftNum = get(nums, left, mid);
        int rightNum = get(nums, mid+1, right);
        int count = leftNum + rightNum;
        int[] help = new int[nums.length];
        int i=left,j = mid+1,index = 0;
        while (i <= mid && j <= right) {
            count += nums[i] > nums[j] ? mid + 1 - i : 0;
            help[index++] = nums[i] <= nums[j] ? nums[i++]:nums[j++];
        }
        while (i <= mid) {
            help[index++] = nums[i++];
        }
        while (j<=right){
            help[index++] = nums[j++];
        }
        System.arraycopy(help, 0, nums, left, right - left + 1);

        return count;
    }

//    private static int merge(int[] arr, int start, int end) {
//        if (start >= end) return 0;
//        int mid = start+(end - start) / 2;
//        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);
//
//        int[] temp = new int[end - start + 1];
//        int i = start, j = mid + 1, k = 0;
//        while (i <= mid && j <= end) {
//            count += arr[i] > arr[j] ? mid + 1 - i  : 0;
//            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
//        }
//        while (i <= mid) {
//            temp[k++] = arr[i++];
//        }
//        while (j <= end)
//            temp[k++] = arr[j++];
//        System.arraycopy(temp, 0, arr, start, end - start + 1);
//        return count;
//    }

}
