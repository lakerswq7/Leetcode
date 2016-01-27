package linkedlist;

public class SortList {
	public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode temp = findMid(head);
        ListNode mid = temp.next;
        // 这里很关键，一定要赋成null，把两个list分开，以此作为停止的终点
        temp.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ((left != null) && (right != null) ) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return dummy.next;
    }
}