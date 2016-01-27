package linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ((headA == null) || (headB == null)) {
            return null;
        }
        ListNode startA = headA;
        ListNode startB = headB;
        int times = 0;
        while (times < 2) {
            if (startA == startB) {
                return startA;
            }
            startA = startA.next;
            startB = startB.next;
            if (startA == null) {
                startA = headB;
                times++;
            }
            if (startB == null) {
                startB = headA;
            }
        }
        return null;
    }
}
