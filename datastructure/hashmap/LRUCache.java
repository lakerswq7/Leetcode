package datastructure.hashmap;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, DoublyLinkedListNode> map;
    int capacity;
    int size;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<Integer, DoublyLinkedListNode>();
        head = new DoublyLinkedListNode(-1, -1);
        tail = new DoublyLinkedListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
    	// 不在就返回 -1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 在有两种情况： 1. 在链头->直接返回	2. 不在链头->从链里面拿出来，再插到链头
        DoublyLinkedListNode temp = map.get(key);
        if (temp != head.next) {
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
            
            head.next.pre = temp;
            temp.next = head.next;
            temp.pre = head;
            head.next = temp;
        }
        return temp.value;
    }
    
    public void set(int key, int value) {
    	// 如果capacity为0就不能插
        if (capacity == 0) {
            return;
        }
        DoublyLinkedListNode temp;
        // 两种情况： 1. 存在->修改值 2. 不存在->新建节点
        if (map.containsKey(key)) {
        	// 存在，如果在链头，直接返回； 不在链头， 则拿出，插入链头
            temp = map.get(key);
            temp.value = value;
            if (temp == head.next) {
                return;
            }
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        } else {
        	// 不存在，如果到达capacity，则删除链尾，把新节点插入链头
            if (size == capacity) {
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                size--;
            }
            // 没到达capacity， 则把新节点直接插入链头
            temp = new DoublyLinkedListNode(key, value);
            map.put(key, temp);
            size++;
        }
        head.next.pre = temp;
        temp.next = head.next;
        temp.pre = head;
        head.next = temp;
    }
    class DoublyLinkedListNode {
        int value;
        int key;
        DoublyLinkedListNode pre;
        DoublyLinkedListNode next;
        DoublyLinkedListNode(int key, int value) {
            this.value = value;
            this.key = key;
            pre = null;
            next = null;
        }
    }
}
