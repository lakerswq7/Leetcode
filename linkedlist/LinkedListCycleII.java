package linkedlist;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode meet = findCycle(head);
        if (meet == null) {
            return null;
        }
        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }
        return meet;
    }
    public ListNode findCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
}
