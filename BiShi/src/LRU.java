import XiaoHongShu.XiaoHongShu01;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args){
      
    }
    private Map<Integer,DoubleLinkNode> map;
    private int cap;//容量
    private DoubleLink dl;
    public LRU(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        dl = new DoubleLink();
        
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        else {
            int val = map.get(key).val;
            put(key,val);
            return val;
        }
    }

    public void put(int key, int value) {
        DoubleLinkNode node = new DoubleLinkNode(key,value);
        if (!map.containsKey(key)) {
            dl.remove(map.get(key));
            dl.put(node);
            map.put(key,node);
        }else {
            if(cap == dl.size){
                DoubleLinkNode last = dl.removeLast();
                map.remove(last.key);
            }
            put(key,value);
            map.put(key,node);
        }
    }

    class DoubleLinkNode{
        DoubleLinkNode pre,next;
        int key;
        int val;

        public DoubleLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleLink{
        DoubleLinkNode head,tail;
        private int size;

        public DoubleLink() {
            size = 0;
            head = new DoubleLinkNode(0,0);
            tail = new DoubleLinkNode(0,0);
            head.next = tail;
            tail.pre = head;
        }

        public void put(DoubleLinkNode node){  //永远插向头
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size++;

        }
        public void remove(DoubleLinkNode node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            size--;
        }

        public DoubleLinkNode removeLast(){
            if(tail.pre == head) return null;
            DoubleLinkNode last = tail.pre;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }

    }
}
