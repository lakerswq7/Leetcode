package linkedlist;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = len - k % len;
        if (k == len) {
            return head;
        }
        ListNode cur = head;
        while (--k > 0) {
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}
