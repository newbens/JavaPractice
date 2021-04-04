package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存淘汰策略
 */
public class Lru {
    //对链表中结点和hashmap做映射关系
    Map<Integer, DoubleLinkedNode> map;
    //双向链表长度
    Integer size;
    //链表模拟缓存淘汰技术
    DoubleLink doubleLink;
    public Lru(int ca) {
        this.size = ca;
        map = new HashMap<>();
        doubleLink = new DoubleLink();
    }

    public int get(int key) {
        //如果map中不存在key返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //如果存在的话，删除原来=结点，并添加到链表头
        DoubleLinkedNode node = map.get(key);
        doubleLink.remove(node);
        doubleLink.put(node);
        return node.val;
    }

    public void put(int key,int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key,value);
        //如果链表中存在数据，返回删除原来数据，添加到表头
        if (map.containsKey(key)) {
            doubleLink.remove(node);
            doubleLink.put(node);
            //建立新节点的映射关系
            map.put(key, node);
        }else {
            //不存在的情况下，先判断链表是否满，如果满，删除尾结点，并将新数据加入到头
            if (doubleLink.getSize() == size) {
                DoubleLinkedNode last = doubleLink.removeLast();
                map.remove(last.key);

            }
                //如果没满，直接头插
                doubleLink.put(node);
                //添加映射关系
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













