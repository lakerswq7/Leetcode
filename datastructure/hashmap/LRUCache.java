package datastructure.hashmap;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeFromList(node);
        insertToHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            removeFromList(node);
        } else {
            node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                removeFromList(tail.pre);
            }
            map.put(key, node);
        }
        insertToHead(node);
    }
    private void insertToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeFromList(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }
    class Node {
        Node pre;
        Node next;
        int key;
        int val;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
}
