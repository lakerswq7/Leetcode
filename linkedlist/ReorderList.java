package linkedlist;

public class ReorderList {
	public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null;
        merge(head, tail);
    }
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ((fast.next != null) && (fast.next.next != null)) {
        	System.out.println("l");
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    public void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        while ((head1 != null) && (head2 != null)) {
        	// 注意这里的次序，每次更新完dummy.next以后必须先更新head
            dummy.next = head1;
            head1 = head1.next;
            dummy.next.next = head2;
            head2 = head2.next;
            dummy = dummy.next.next;
            
        }
        // 只有一种可能，因为head1序列一定比head2多
        if (head1 != null) {
            dummy.next = head1;
        }
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		ReorderList solution = new ReorderList();
		solution.reorderList(a);
		System.out.println(a.val);
		System.out.println(a.next.val);
	}
}
