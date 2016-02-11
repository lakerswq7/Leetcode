package linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (carry != 0 || l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
