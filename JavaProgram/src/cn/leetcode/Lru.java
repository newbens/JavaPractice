package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ������̭����
 */
public class Lru {
    //�������н���hashmap��ӳ���ϵ
    Map<Integer, DoubleLinkedNode> map;
    //˫��������
    Integer size;
    //����ģ�⻺����̭����
    DoubleLink doubleLink;
    public Lru(int ca) {
        this.size = ca;
        map = new HashMap<>();
        doubleLink = new DoubleLink();
    }

    public int get(int key) {
        //���map�в�����key����-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //������ڵĻ���ɾ��ԭ��=��㣬����ӵ�����ͷ
        DoubleLinkedNode node = map.get(key);
        doubleLink.remove(node);
        doubleLink.put(node);
        return node.val;
    }

    public void put(int key,int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key,value);
        //��������д������ݣ�����ɾ��ԭ�����ݣ���ӵ���ͷ
        if (map.containsKey(key)) {
            doubleLink.remove(node);
            doubleLink.put(node);
            //�����½ڵ��ӳ���ϵ
            map.put(key, node);
        }else {
            //�����ڵ�����£����ж������Ƿ������������ɾ��β��㣬���������ݼ��뵽ͷ
            if (doubleLink.getSize() == size) {
                DoubleLinkedNode last = doubleLink.removeLast();
                map.remove(last.key);

            }
                //���û����ֱ��ͷ��
                doubleLink.put(node);
                //���ӳ���ϵ
                map.put(key, node);
            }
        }
    }



class DoubleLink{
    DoubleLinkedNode head,tail;
    private int size;

    public DoubleLink() {
        head = new DoubleLinkedNode(0,0);
        tail = new DoubleLinkedNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public void put(DoubleLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    public void remove(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public DoubleLinkedNode removeLast() {
        if (tail.pre == head) {
            return null;
        }
        DoubleLinkedNode remove = tail.pre;
        remove(remove);
        return remove;
    }

    public Integer getSize() {
        return size;
    }
}


class DoubleLinkedNode{
    DoubleLinkedNode pre,next;
    Integer key;
    Integer val;

    public DoubleLinkedNode(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }
}













