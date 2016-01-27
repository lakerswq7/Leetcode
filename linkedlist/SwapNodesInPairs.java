package linkedlist;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while ((cur.next != null) && (cur.next.next != null)) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = temp;
        }
        return dummy.next;
    }
}
