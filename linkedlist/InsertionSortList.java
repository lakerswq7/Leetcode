package linkedlist;


public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = first;
        ListNode check = head;
        ListNode temp;
        // 这里需要注意，以后遇到linked list删除和插入的情况，要拿住前一个节点，考察后一个节点
        while (check.next != null) {
        	// 两层循环归并到一层循环中来，这里注意因为check的检查是在外层循环条件中，所以当更新了check之后
        	// 一定要重新开始循环，以检查check的合法性
            if (check.next == cur.next) {
                cur = first;
                check = check.next;
                continue;
            }
            if (check.next.val <= cur.next.val) {
            	// 先把check.next从链中拿出来，再把它插到cur的后面去
                temp = check.next;
                check.next = check.next.next;
                temp.next = cur.next;
                cur.next = temp;
                cur = first;
            } else {
                cur = cur.next;
            }
        }
        return first.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(4);
		a.next = b;
		b.next = c;
		InsertionSortList solution = new InsertionSortList();
		ListNode d = solution.insertionSortList(a);
		System.out.println(d.val);
		System.out.println(d.next.val);
		System.out.println(d.next.next.val);
	}
}
