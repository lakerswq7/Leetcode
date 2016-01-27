package linkedlist;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = first;
        int dup;
        while ((cur.next != null) && (cur.next.next != null)) {
            dup = cur.next.val;
            // 如果有重复的就把所有重复的连同第一个一块删掉
            if (cur.next.next.val == dup) {
            	// 这里要判断是不是null
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
