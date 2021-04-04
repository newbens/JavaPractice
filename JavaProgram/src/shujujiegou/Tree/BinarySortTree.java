package shujujiegou.Tree;

//******************************************二叉排序树**************************************
public class BinarySortTree {
    public static void main(String[] args) {
        int[] a = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortT b = new BinarySortT();
        for (int i : a) {
            BstS bs = new BstS(i);
            b.add(bs);
        }
        b.minPrint();
        b.detele(10);
        b.minPrint();
    }
}

class BinarySortT {
    BstS head = null;

    public void add(BstS node) {
        if (head == null) {
            head = node;
        } else {
            head.add(node);
        }
    }

    public BstS search(int val) {
        if (head == null) {
            return null;
        } else {
            return head.search(val);
        }
    }

    public BstS searchFather(int val) {
        if (head == null) {
            return null;
        } else {
            return head.searchFather(val);
        }
    }

    public void detele(int val) {
        if (head == null) {
            return;
        } else {
            BstS targetNode = search(val);
            if (targetNode == null) {
                return;
            }
            //如何想要删除的结点是叶节点，直接置空，无需其他操作
            BstS father = searchFather(val);
            if (targetNode.left == null && targetNode.right == null) {   //叶子
                if (father.left != null && father.left.val == val) {
                    father.left = null;
                } else if (father.right != null && father.right.val == val) {
                    father.right = null;
                }
                //有两个子树,删除这个数就要找到与这个数最相近的数，然后将这个数的值赋值给待删除结点，最后删除这个数
            } else if (targetNode.left != null && targetNode.right != null) {
                int temp = delRightTreeMin(targetNode.right);
                targetNode.val = temp;
            } else {   //一个的话需要判断是左是右。还有判断待删除结点时父节点的左右
                if (targetNode.left != null) {
                    if (father.left.val == val) {
                        father.left = targetNode.left;
                    } else {
                        father.right = targetNode.left;
                    }
                } else {
                    if (father.left.val == val) {
                        father.left = targetNode.right;
                    } else {
                        father.right = targetNode.right;
                    }
                }

            }
        }
    }

    public int delRightTreeMin(BstS node) {
        BstS temp = node;
        while (temp.left != null) {
            temp =temp.left;
        }
        int res = temp.val;
        detele(res);
        return res;
    }

    public void minPrint() {
        if (head != null) {
            head.minPrint();
        } else {
            System.out.println("空！！！");
        }
    }
}


class BstS {
    int val;
    BstS left;
    BstS right;

    public BstS(int val) {
        this.val = val;
    }

    public void add(BstS node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }

    public BstS search(int val) {
        if (val == this.val) {
            return this;
        } else if (val < this.val) {   //小了向左找
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(val);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(val);
            }
        }
    }

    public BstS searchFather(int val) {
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            if (val < this.val && this.left != null) {
                return this.left.searchFather(val);
            } else if (val >= this.val && this.right != null) {
                return this.right.searchFather(val);
            } else {
                return null;
            }
        }

    }

    public void minPrint() {
        if (this.left != null) {
            this.left.minPrint();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.minPrint();
        }
    }

    @Override
    public String toString() {
        return "BstS{" +
                "val=" + val +
                '}';
    }
}