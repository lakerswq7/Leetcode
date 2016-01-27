package linkedlist;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = first;
        int dup;
        while ((cur.next != null) && (cur.next.next != null)) {
            dup = cur.next.val;
            // ������ظ��ľͰ������ظ�����ͬ��һ��һ��ɾ��
            if (cur.next.next.val == dup) {
            	// ����Ҫ�ж��ǲ���null
                while ((cur.next != null) && (cur.next.val == dup)) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return first.next;
    }
}
