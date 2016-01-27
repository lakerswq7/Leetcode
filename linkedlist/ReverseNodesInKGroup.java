package linkedlist;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if ((head == null) || (k == 0) || (k == 1)) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // 先计算这个linked list的长度，以此计算还能不能reverse
        int length = getLength(head);
        while (length >= k) {
        	// cur 返回的是反转list的最后一个
            cur = reverse(cur, k);
            length = length - k;
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode pre, int k) {
        ListNode head = pre.next;
        ListNode newHead = null;
        ListNode temp;
        for (int i = 0; i < k; i++) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        // tail 表示反转list的最后一个，newHead表示反转list的第一个
        // head表示反转list的下一个，pre表示反转list的上一个
        ListNode tail = pre.next;
        pre.next = newHead;
        tail.next = head;
        return tail;
    }
    public int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}
