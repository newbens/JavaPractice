//package cn.leetcode;
//
////山顶数组查找值
//public interface Test1095 {
//    int get(int index);
//
//    public int length();
//}
//
//class MountainArrayIpm implements Test1095 {
//    private int[] arr;
//
//    public MountainArrayIpm(int[] arr) {
//        this.arr = arr;
//    }
//
//    @Override
//    public int get(int index) {
//        return this.arr[index];
//    }
//
//    @Override
//    public int length() {
//        return this.arr.length;
//    }
//}
//
//class Solution {
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 3, 1};
//        int target = 3;
//        Test1095 marry = new MountainArrayIpm(arr);
//        int res = new Test130().findLeft(marry,target);
//        if (res != -1) {
//            System.out.println(res);
//        }else {
//            res = new Test130().findRight(marry, target);
//            System.out.println(res);
//        }
//
//
//    }
//
//    private int findMarry(Test1095 marry) {
//        int left = 0, right = marry.length() - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (marry.get(mid) > marry.get(mid + 1)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//    public int findLeft(Test1095 marry, int target) {  //left为升序数组
//        int left = 0, right = findMarry(marry) - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (marry.get(mid) < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        if (marry.get(left) == target) {
//            return left;
//        }else {
//            return  -1;
//        }
//    }
//
//    public int findRight(Test1095 marry, int target) {  //right为递减数组
//        int left = findMarry(marry) + 1, right = marry.length() - 1;
//        while (left < right) {
//            int mid = left + (right - left + 1) / 2;
//            if (marry.get(mid) < target) {
//                right = mid - 1;
//            } else {
//                left = mid;
//            }
//        }
//        if (marry.get(left) == target) {
//            return left;
//        }else {
//            return  -1;
//        }
//
//    }
//
//}
