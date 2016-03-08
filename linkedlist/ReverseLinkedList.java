package linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    // recursion
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode node = head.next;
//        head.next = null;
//        ListNode newHead = reverseList(node);
//        node.next = head;
//        return newHead;
//    }
}
