package HuaWei;

import java.util.*;

public class HuaWei05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Node> res = new ArrayList<>();
        HashMap<String, Info> map = new HashMap();
        while (sc.hasNext()){
            String url = sc.nextLine();
            int i = url.lastIndexOf("\\");
            String[] newStrs = url.substring(i + 1, url.length()).split(" ");
            int len = newStrs[0].length();
            if (map.containsKey(newStrs[0]) && map.get(newStrs[0]).hang.equals(newStrs[1])) {
                if (len > 16){
                    newStrs[0] =  newStrs[0].substring(len - 17, len - 1);
                }
                Info integer = map.get(newStrs[0]);
                res.get(integer.index).count++;
            } else {
                map.put(newStrs[0], new Info(newStrs[1], res.size()));
                res.add(new Node(newStrs[0],newStrs[1], 1));
            }

        }
        res.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count - o1.count;
            }
        });
        if (res.size() > 8) {
            for (int i = 0; i < 8; i++) {
                System.out.println(res.get(i).toString());
            }
        }else {
            for (Node re : res) {
                System.out.println(re.toString());
            }
        }


    }

    public static class Node {
        String string;
        String hang;
        int count;

        public Node(String string, String hang, int count) {
            this.string = string;
            this.hang = hang;
            this.count = count;
        }

        @Override
        public String toString() {
            return string + " "+hang+" " + count;
        }
    }
    public static class Info{
        String hang;
        int index;

        public Info(String hang, int index) {
            this.hang = hang;
            this.index = index;
        }
    }
}
