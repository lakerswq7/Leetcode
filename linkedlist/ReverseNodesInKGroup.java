package linkedlist;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if ((head == null) || (k == 0) || (k == 1)) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // �ȼ������linked list�ĳ��ȣ��Դ˼��㻹�ܲ���reverse
        int length = getLength(head);
        while (length >= k) {
        	// cur ���ص��Ƿ�תlist�����һ��
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
        // tail ��ʾ��תlist�����һ����newHead��ʾ��תlist�ĵ�һ��
        // head��ʾ��תlist����һ����pre��ʾ��תlist����һ��
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
