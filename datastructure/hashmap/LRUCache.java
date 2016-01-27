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
    	// ���ھͷ��� -1
        if (!map.containsKey(key)) {
            return -1;
        }
        // ������������� 1. ����ͷ->ֱ�ӷ���	2. ������ͷ->���������ó������ٲ嵽��ͷ
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
    	// ���capacityΪ0�Ͳ��ܲ�
        if (capacity == 0) {
            return;
        }
        DoublyLinkedListNode temp;
        // ��������� 1. ����->�޸�ֵ 2. ������->�½��ڵ�
        if (map.containsKey(key)) {
        	// ���ڣ��������ͷ��ֱ�ӷ��أ� ������ͷ�� ���ó���������ͷ
            temp = map.get(key);
            temp.value = value;
            if (temp == head.next) {
                return;
            }
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        } else {
        	// �����ڣ��������capacity����ɾ����β�����½ڵ������ͷ
            if (size == capacity) {
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                size--;
            }
            // û����capacity�� ����½ڵ�ֱ�Ӳ�����ͷ
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
