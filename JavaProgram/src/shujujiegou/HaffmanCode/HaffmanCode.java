package shujujiegou.HaffmanCode;

import java.util.*;
/*哈夫曼编码压缩
    思路：
        1.将传入数组转换成字节数组。
        2.求出字节数组中每个出现的数组，存入数组。将每个字节和出现次数转化成Node对象，data保存数据，weight
          保存出现次数。
        3.构建哈夫曼树，出现次数为权值。
        4.通过哈夫曼出求出每个字节的编码，左0右1，字节都在叶子节点，遍历树实现求出每个字节的编码，存入hashmap
          形成映射关系。
        5.遍历第一步的字节数组，在hashmap中查找对应的编码替换，
        6.最后将替换后的编码转成byte数组返回。
 */

public class HaffmanCode {
    public static void main(String[] args) {
        String string = "abcdefghijklmn";
        byte[] res = huffmanZip(string);
        System.out.println(Arrays.toString(res));
        byte[] unzip = unZip(HfmCodeList,res);
        System.out.println(new String(unzip));

    }

    /*封装全部方法
        @param bytes 原始数据的bytes数组
        @return  经过哈夫曼编码压缩后的数组
     */
    public static byte[] huffmanZip(String s) {
        byte[] bytes = s.getBytes();  //字符串转字节
        List list = getNode(bytes);   //求各各字节出现的次数（此时数组存的数据是Node类型数据）
        Node head = createHaffman(list);   //构造哈夫曼树并获得树的头结点
        getCode(head, "", str);
        byte[] result = transCode(bytes, HfmCodeList);
        return result;
    }

    private static List<Node> getNode(byte[] b) {
        ArrayList<Node> arrayList = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte i : b) {     //将字符出现次数和字节存入map
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {    //将数据转入数组
            arrayList.add(new Node(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Node createHaffman(List<Node> list) {   //构造哈夫曼树
        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(0);
            list.remove(0);
            list.add(parent);
        }
        return list.get(0);
    }
    static StringBuilder stringBuilder = new StringBuilder();
    public static byte[] transCode(byte[] bytes, Map<Byte, String> hfmCode) {      //转码
        for (byte b : bytes) {
            stringBuilder.append(hfmCode.get(b));
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        int len = (stringBuilder.length() + 7) / 8;  //获取长度
        byte[] haffmanCode = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String s;
            if (i + 8 > stringBuilder.length()) {
                s = stringBuilder.substring(i);
            } else {
                s = stringBuilder.substring(i, i + 8);
            }
            haffmanCode[index] = (byte) Integer.parseInt(s, 2);
            index++;

        }
        return haffmanCode;
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        } else {
            head.pre();
        }

    }

    static Map<Byte, String> HfmCodeList = new HashMap<>();//存放字节和编码的映射关系
    static StringBuilder str = new StringBuilder();

    public static void getCode(Node node, String path, StringBuilder str) {
        StringBuilder s = new StringBuilder(str);  //用于存放编码的字符串
        s.append(path);
        if (node.data == null) {   //说明是非叶子结点
            if (node.left != null) {
                getCode(node.left, "0", s);
            }
            if (node.right != null) {
                getCode(node.right, "1", s);
            }
        } else {
            HfmCodeList.put(node.data, s.toString());  //递归到叶子结点就将叶子节点的数据和编码存入map
        }

    }

    //*****************************解码块*******************************
    public static String byteToString(byte b, boolean flag,int i) {
        int temp = b;
            temp |= 256; //如果是正数，需要补位
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);
        } else {
            return s.substring(s.length()-(stringBuilder.length()-(i*8)));
        }
    }

    public static byte[] unZip(Map<Byte,String> hfmCodeList,byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <bytes.length ; i++) {
            boolean flag = (i == bytes.length - 1);
            stringBuilder.append(byteToString(bytes[i], !flag,bytes.length-1));
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : HfmCodeList.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i <stringBuilder.length() ; i++) {
            stringBuilder1.append(stringBuilder.substring(i,i+1));
            if (map.containsKey(stringBuilder1.toString())) {   //切记这里StringBuilder转String
                list.add(map.get(stringBuilder1.toString()));
                stringBuilder1.delete(0, stringBuilder1.length());
            }
        }
        StringBuilder result = new StringBuilder();
        byte[] b = new byte[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            b[i] = list.get(i);
        }
        return b;
    }
}


class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;  //从小到大排序
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void pre() {
        System.out.println(this);
        if (this.left != null) {
            this.left.pre();
        }
        if (this.right != null) {
            this.right.pre();
        }
    }
}
