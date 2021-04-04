package cn.leetcode.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 思路：前序遍历可以确定根节点，然后通过前序遍历得到的根节点将中序遍历分成左右子树，层层递归得出答案。
 */
public class Test07 {
    int[] pre_temp;
    Map<Integer, Integer> map;  //存入结点和对应的下标

    public static void main(String[] args) {
        int[] pre = {3, 9, 2, 15, 7};
        int[] mid = {9, 3, 15, 20, 7};
        Tnode init = new Test07().init(pre, mid);
        System.out.println();
    }

    public Tnode init(int[] pre, int[] mid) {
        pre_temp = pre;
        map = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            map.put(mid[i], i);
        }
        Tnode slove = slove(0, mid.length - 1, 0);
        return slove;


    }

    /**
     *
     * @param root_index   根节点    前序遍历数组的第一个树就是根节点
     * @param right_index  子树右边界
     * @param left_index    子树左边界
     * @return
     */
    public Tnode slove(int root_index, int right_index, int left_index) {
        if (left_index > right_index) {  //退出递归条件
            return null;
        }
        int index = map.get(pre_temp[root_index]); //得到根节点对应的下标
        Tnode root = new Tnode(pre_temp[root_index]);
        //根结点的下一个就是左子树的根结点
        root.left = slove(root_index + 1, index - 1, 0);
        //右子树的根节点下标是  根节点下标加上左子树个数+1，
        root.right = slove(root_index + (index - 1 - right_index + 1) + 1, right_index, index + 1);
        return root;
    }
}

class Tnode{
    Integer val;
    Tnode left;
    Tnode right;

    public Tnode(Integer val) {
        this.val = val;
    }
}
