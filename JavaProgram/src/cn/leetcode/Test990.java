package cn.leetcode;

//union-findģ���� ���鼯
public class Test990 {

    public static void main(String[] args) {
        String[] e = {"a==b","b==a"};
        int[] parent = new int[26];
        //��ʼ����ÿ���ڵ�ĸ��ڵ����Լ�
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //�Ƚ�������ȵĵ�ʽ�������Ӹ���ϵ
        for (String s : e) {
            if (s.charAt(1) == '!') {
                continue;
            }
            int le = s.charAt(0) - 'a';
            int ri = s.charAt(3) - 'a';
            union(parent,le,ri);
        }
        //�������в���ʽ�Ĺ�ϵ�����Υ����ȵ��Ӹ���ϵ��ֱ��return  false��
        for (String s : e) {
            if (s.charAt(1) == '=') {
                continue;
            }
            int le = s.charAt(0) - 'a';
            int ri = s.charAt(3) - 'a';
            if (find(parent, le) == find(parent, ri)) {
                System.out.println("false");
            }
        }
        System.out.println("....");

    }
    //����ÿ���ĸ��ڵ�
    public static void union(int[] parent,int i,int j) {
        int i1 = find(parent, i);
        int i2 = find(parent, j);
        parent[i1] = i2;
    }
    //����ÿ���ڵ�ĸ��ڵ�
    public static int find(int[] parent,int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return parent[i];
    }
}

