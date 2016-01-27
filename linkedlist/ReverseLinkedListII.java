package linkedlist;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        head = first;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        reverseK(head, n - m + 1);
        return first.next;
    }
    public void reverseK(ListNode first, int k) {
        ListNode newHead = null;
        ListNode head = first.next;
        ListNode temp;
        for(int i = 0; i < k; i++) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        first.next.next = head;
        first.next = newHead;
    }
    public static void main(String[] args) {
    	ListNode a = new ListNode(5);
    	ReverseLinkedListII solution = new ReverseLinkedListII();
    	solution.reverseBetween(a, 1, 1);
    }
}
