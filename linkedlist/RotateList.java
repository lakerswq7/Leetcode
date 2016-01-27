package linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        ListNode tail = head, work = head;
        int rotate, length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        rotate = n % length;
        if (rotate == 0) return head;
        while (rotate < length - 1) {
            work = work.next;
            rotate++;
        }
        tail.next = head;
        ListNode newHead = work.next;
        work.next = null;
        return newHead;
    }
}
